package com.springboot.oauth2.repository;

import com.springboot.oauth2.domain.Member;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "user") // "/members" -> "/user" 형태로 URI를 변경한다
public interface MemberRepository extends PagingAndSortingRepository<Member, Long> {

}
