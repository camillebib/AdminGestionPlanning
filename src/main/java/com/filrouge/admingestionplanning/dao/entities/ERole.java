package com.filrouge.admingestionplanning.dao.entities;

import java.util.Objects;

public enum ERole {
    ROLE_USER (1L, "User"),
    ROLE_MODERATOR (2L, "Moderator"),
    ROLE_ADMIN (3L, "Admin");

    private Long id;
    private String name;

    private ERole(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public static Role getRoleById (Long id){
        for (ERole eRole : ERole.values()){
            if (Objects.equals(eRole.id, id)){
                Role role = new Role();
                role.setId(eRole.id);
                role.setName(eRole.name);
                return role;
            }
        }
        return null;
    }
}

