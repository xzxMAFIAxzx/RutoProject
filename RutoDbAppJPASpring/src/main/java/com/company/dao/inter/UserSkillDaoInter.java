package com.company.dao.inter;

import com.company.entity.UserSkill;


import java.util.List;

public interface UserSkillDaoInter {
    public List<UserSkill> getUserSkill (String skilId,String power);
    public boolean insertUserSkill (UserSkill id);
    public boolean updateUserSkill (UserSkill s);
    public boolean removeUserSkill (int id);

}
