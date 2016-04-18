package com.fjsaas.web.utils.excel;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public abstract class SxlsxAbstract {
	
	private SxlsxSheet currentSheet;
	private int sheetIndex = 0;
	private ArrayList<SxlsxSheet> sheetList = new ArrayList<SxlsxSheet>();
	
	private String position;
	private int sheetRId;
	//int titleRowIndex = 1;
    boolean isReadHeader;

	public void processFirstSheet(String filename,boolean isReadHeader) throws Exception {
		processSheet(filename,1,isReadHeader);
	}
	
	public void processSheet(String filename,int sheetRId,boolean isReadHeader) throws Exception {
		this.sheetRId = sheetRId;
		this.isReadHeader = isReadHeader;
		OPCPackage pkg = OPCPackage.open(filename, PackageAccess.READ);
		try {
			XSSFReader r = new XSSFReader(pkg);
			SharedStringsTable sst = r.getSharedStringsTable();

			XMLReader parser = fetchSheetParser(sst);

			InputStream sheet2 = r.getSheet("rId"+sheetRId);
			InputSource sheetSource = new InputSource(sheet2);
			parser.parse(sheetSource);
			sheet2.close();
		} finally {
			pkg.close();
		}
	}

	public void processAllSheets(String filename,boolean isReadHeader) throws Exception {
		this.isReadHeader = isReadHeader;
		OPCPackage pkg = OPCPackage.open(filename, PackageAccess.READ);
		try {
			XSSFReader r = new XSSFReader(pkg);
			SharedStringsTable sst = r.getSharedStringsTable();

			XMLReader parser = fetchSheetParser(sst);

			Iterator<InputStream> sheets = r.getSheetsData();
			while (sheets.hasNext()) {
				InputStream sheet = sheets.next();
				InputSource sheetSource = new InputSource(sheet);
				parser.parse(sheetSource);
				sheet.close();
				System.out.println("");
			}
		} finally {
			pkg.close();
		}
	}

	public XMLReader fetchSheetParser(SharedStringsTable sst) throws SAXException {
		XMLReader parser = XMLReaderFactory.createXMLReader();
		ContentHandler handler = new SheetHandler(sst);
		parser.setContentHandler(handler);
		return parser;
	}
	
	public abstract void ProcessRow(int sheetIndex,int curRow, List<String> row);

	public abstract String ProcessCell(int sheetIndex,int curRow, int curColumn,String position,String value);
	/**
	 * See org.xml.sax.helpers.DefaultHandler javadocs
	 */
	private class SheetHandler extends DefaultHandler {
		private SharedStringsTable sst;
		private String lastContents;
		private boolean nextIsString;
		private boolean inlineStr;	
		
		private SheetHandler(SharedStringsTable sst) {
			this.sst = sst;
		}

		public void startElement(String uri, String localName, String name,
								 Attributes attributes) throws SAXException {
			//System.out.println("name:"+name+";r:"+attributes.getValue("r")+";t:"+attributes.getValue("t"));
			if(name.equals("worksheet")){
				sheetIndex++;
				currentSheet = new SxlsxSheet();
				//currentSheet.setTitleRowIndex(titleRowIndex);
				sheetList.add(currentSheet);
			}
			
			if(name.equals("row")){
				currentSheet.addRowIndex(1);
				//rowIndex++;
				currentSheet.setNewRow(true);
				//isNewRow = true;
				currentSheet.setColumnIndex(0);
				//columnIndex = 0;
			}
			// c => cell
			if(name.equals("c")) {
				// Print the cell reference	
				position = attributes.getValue("r");
				//System.out.print(attributes.getValue("r") + " - ");获取cell的坐标，如E5
				// Figure out if the value is an index in the SST
				String cellType = attributes.getValue("t");
				nextIsString = cellType != null && cellType.equals("s");
				inlineStr = cellType != null && cellType.equals("inlineStr");
			}
			// Clear contents cache
			lastContents = "";
		}

		public void endElement(String uri, String localName, String name)
				throws SAXException {
			// Process the last contents as required.
			// Do now, as characters() may be called more than once
			if(nextIsString) {
				int idx = Integer.parseInt(lastContents);
				lastContents = new XSSFRichTextString(sst.getEntryAt(idx)).toString();
				nextIsString = false;
			}

			// v => contents of a cell
			// Output after we've seen the string contents
			if(name.equals("v") || (inlineStr && name.equals("c"))) {
				//System.out.println(lastContents);
				
				if(currentSheet.getRowIndex() == 1 && isReadHeader){
					currentSheet.getTitleRow().add(currentSheet.getColumnIndex(),lastContents);//titleRow.add(columnIndex++, lastContents);
					currentSheet.addColumnIndex(1);
				}else{
					if(currentSheet.isNewRow()/*isNewRow*/){
						//currentRow = new ArrayList<String>();
						ArrayList<String> list = new ArrayList<String>();
						currentSheet.setCurrentRow(list);
						currentSheet.getDataList().add(list);
						//dataList.add(currentRow);
						currentSheet.setNewRow(false);
						//isNewRow = false;
					}
					//System.out.println(lastContents);
					//columnIndex++;
					currentSheet.addColumnIndex(1);
					//lastContents = ProcessCell(sheetRId,rowIndex,columnIndex,position,lastContents);
					lastContents = ProcessCell(sheetIndex,currentSheet.getRowIndex(),currentSheet.getColumnIndex(),position,lastContents);
					
					
					currentSheet.getCurrentRow().add(currentSheet.getColumnIndex()-1,lastContents);
					//currentRow.add(columnIndex-1,lastContents);
				}
				
				/*if(lastColumnNumber < columnIndex){
					lastColumnNumber = columnIndex;
				}*/
				if(currentSheet.getLastColumnNumber() < currentSheet.getColumnIndex()){
					currentSheet.setLastColumnNumber(currentSheet.getColumnIndex());
				}
			}
			
			if(name.equals("row")){
				/*if(lastRowNumber < rowIndex){
					lastRowNumber = rowIndex;
				}*/
				if(currentSheet.getLastRowNumber() < currentSheet.getRowIndex()){
					currentSheet.setLastRowNumber(currentSheet.getRowIndex());
				}
				
				//ProcessRow(sheetRId, rowIndex, currentRow);currentSheet.getRowIndex() == 1 && readTitle
				if(isReadHeader){
					if(currentSheet.getRowIndex() > 1){
						ProcessRow(sheetRId, currentSheet.getRowIndex(), currentSheet.getCurrentRow());
					}
				}else{
					ProcessRow(sheetRId, currentSheet.getRowIndex(), currentSheet.getCurrentRow());
				}
				
			}						
		}

		public void characters(char[] ch, int start, int length) throws SAXException { // NOSONAR
			lastContents += new String(ch, start, length);
		}
		
	}
		
}
