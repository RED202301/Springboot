package hello.core.member;

import java.util.HashMap;
import java.util.Map;
//메모리 멤버레포지토리로 테스트
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
//    동시성 이슈때문에 Hashmap보단 Concurrent Hashmap을 써야함
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
