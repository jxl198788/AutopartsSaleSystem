package com.fjsaas.web.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authz.permission.WildcardPermission;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fjsaas.web.bean.Resource;
import com.fjsaas.web.constants.ResourceType;
import com.fjsaas.web.dao.ResourceMapper;
import com.fjsaas.web.service.ResourceService;

/**
 * 资源业务实现
 * 
 * 
 */
@Service
public class ResourceServiceImpl implements ResourceService {

    @javax.annotation.Resource
    private ResourceMapper resourceMapper;

    @Override
    public int create(Resource res) {
        return resourceMapper.create(res);
    }

    @Override
    public int update(Resource res) {
        return resourceMapper.update(res);
    }

    @Override
    public int delete(int reid) {
        return resourceMapper.delete(reid);
    }

    @Override
    public Resource get(int reid) {
        return resourceMapper.get(reid);
    }

    @Override
    public List<Resource> all() {
        return resourceMapper.all();
    }

    @Override
    public List<Resource> getMenus(Set<String> permissions) {
        List<Resource> resources = all();
        List<Resource> menus = new ArrayList<Resource>();
        if (resources != null && resources.size() > 0) {
            for (Resource resource : resources) {
                if (resource.getPid() == 0)
                    continue;
                if (resource.getType() != ResourceType.MENU)
                    continue;
                if (!hasPermission(permissions, resource))
                    continue;
                menus.add(resource);
            }
        }

        return menus;
    }

    /**
     * 判断是否拥有资源权限
     * 
     * @param permissions
     * @param resource
     * @return
     */
    private boolean hasPermission(Set<String> permissions, Resource resource) {
        // 无权限字符串的菜单表示开放
        if (StringUtils.isEmpty(resource.getPermissions()))
            return true;
        for (String permission : permissions) {
            WildcardPermission p1 = new WildcardPermission(permission);
            WildcardPermission p2 = new WildcardPermission(resource.getPermissions());
            if (p1.implies(p2) || p2.implies(p1)) {
                return true;
            }
        }
        return false;
    }
}
