package com.toy.service;

import com.toy.dto.ToyMemberDto;

public interface ToyMemberService {
    public ToyMemberDto selectOne(String userId, String password);
    public boolean insert(ToyMemberDto dto);
}
