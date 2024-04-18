package com.fofo.core.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberAppender memberAppender;
    private final MemberFinder memberFinder;
    private final MemberUpdater memberUpdater;

    public long append(final Member member, final Address address) {
        return memberAppender.append(member, address);
    }

    public MemberWithAddress find(final long memberId) {
        return memberFinder.find(memberId);
    }

    public Page<MemberWithAddress> findAll(final FindMember findMember, final int pageNumber, final int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return memberFinder.findAll(findMember, pageRequest);
    }

    public long update(final long memberId, final UpdateMember updateMember, final UpdateAddress updateAddress) {
        return memberUpdater.update(memberId, updateMember, updateAddress);
    }

    public long remove(final long memberId) {
        return memberUpdater.remove(memberId);
    }
}
