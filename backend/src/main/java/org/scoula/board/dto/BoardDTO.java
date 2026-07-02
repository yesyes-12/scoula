package org.scoula.board.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.domain.BoardVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// 비즈니스 계층: VO + 추가적인 정보 덧붙여 Service, controller, view 등에서 사용(Dao제외)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(description = "게시글 DTO") // 모델 이름 등록
public class BoardDTO {

    @ApiModelProperty(value="게시글 ID", example = "1")
    private Long no;
    @ApiModelProperty(value="제목")
    private String title;
    @ApiModelProperty(value="글 본문")
    private String content;
    @ApiModelProperty(value="작성자")
    private String writer;
    @ApiModelProperty(value="등록일")
    private Date regDate;
    @ApiModelProperty(value="수정일")
    private Date updateDate;

    // 첨부 파일
    @ApiModelProperty(value="첨부파일 목록")
    private List<BoardAttachmentVO> attaches;

    @ApiModelProperty(value="업로드 파일 목록")
    List<MultipartFile> files = new ArrayList<>(); // 실제 업로드된 파일(multipart) 목록

    // VO → DTO 변환
    public static BoardDTO of(BoardVO vo){
        return vo == null ? null : BoardDTO.builder()
                                   .no(vo.getNo())
                                   .title(vo.getTitle())
                                   .content(vo.getContent())
                                   .writer(vo.getWriter())
                                   .attaches(vo.getAttaches())
                                   .regDate(vo.getRegDate())
                                   .updateDate(vo.getUpdateDate())
                                   .build();
    }

    // DTO → VO 변환
    public BoardVO toVO(){
        return BoardVO.builder()
                .no(no)
                .title(title)
                .content(content)
                .writer(writer)
                .attaches(attaches)
                .regDate(regDate)
                .updateDate(updateDate)
                .build();
    }
}
