package com.example.jwttoken2.dto.response.View;

import com.example.jwttoken2.dto.response.GroupResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter@Setter
public class GroupsResponseView {
    List<GroupResponse> groupResponses;
}
