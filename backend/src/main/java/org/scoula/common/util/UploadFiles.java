package org.scoula.common.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;

public class UploadFiles {
    public static String upload(String baseDir, MultipartFile part) throws IOException {

        // 기본 디렉토리 있는지 확인, 없으면 생성
        File base = new File(baseDir);
        if(!base.exists()){
            base.mkdirs(); // 중간에 존재하지 않는 디렉토리까지 모두 생성
        }

        String fileName = part.getOriginalFilename();
        File dest = new File(baseDir, UploadfileName.getUniqName(fileName));
        part.transferTo(dest); // 지정된 경로로 업로드 파일 이동
        return dest.getPath(); // 지정된 파일 경로 리턴
    }

    public static String getFormatSize(Long size){
        if(size <= 0) return "0";

        final String[] units = new String[] {"Bytes", "KB", "MB", "GB", "TB"};
        int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
        return new DecimalFormat("#,##0.#").format(size/Math.pow(1024, digitGroups)) + " " + units[digitGroups];

    }

    // 파일 다운로드
    public static void download(HttpServletResponse response, File file, String orgName) throws Exception {
        response.setContentType("applicaion/download");
        response.setContentLength((int)file.length());

        String filename = URLEncoder.encode(orgName, "UTF-8"); // 한글 파일명인 경우 인코딩 필수

        // 응답 헤더로 파일 첨부 정보 설정
        response.setHeader("Content-disposition", "attachment;filename=\"" + filename + "\"");

        // httpresponse에 binary stream을 얻어 직접 write
        try(OutputStream os = response.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(os)){
            Files.copy(Paths.get(file.getPath()), bos);
        }
    }

    public static void downloadImage(HttpServletResponse response, File file) {
        try {
            Path path = Path.of(file.getPath());
            String mimeType = Files.probeContentType(path);
            response.setContentType(mimeType);
            response.setContentLength((int) file.length());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
