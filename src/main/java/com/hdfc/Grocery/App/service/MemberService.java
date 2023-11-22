package com.hdfc.Grocery.App.service;

import com.hdfc.Grocery.App.dao.MemberRepository;
import com.hdfc.Grocery.App.dao.UserRepository;
import com.hdfc.Grocery.App.entity.Member;
import com.hdfc.Grocery.App.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    private UserRepository userRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository, UserRepository userRepository) {
        this.memberRepository = memberRepository;
        this.userRepository = userRepository;
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> getMemberById(Long id) {
        return memberRepository.findById(id);
    }

    public Member createMember(Member member) {
        if (member.getRole().equals("user")) {
            User user = userRepository.save(new User(member.getName(), BigDecimal.valueOf(0), BigDecimal.valueOf(0)));
        }
        return memberRepository.save(member);

    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
}

