package cn.doeon.farm.shop.common.util;

import cn.hutool.core.io.FileUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Component
@AllArgsConstructor
public class FileUploadUtil {
    public final static String NORM_MONTH_PATTERN = "yyyy/MM/";

    public static String approvalFile(MultipartFile filecontent, String datePath, String picName){
        OutputStream os = null;
        InputStream inputStream = null;
        String path = null;
        try {
            inputStream = filecontent.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            // Linux 文件保存的路径
            path = datePath;
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流保存到本地文件
            File tempFile = new File(path);
            if (!tempFile.exists()) {
                tempFile.mkdirs();
            }
            os = new FileOutputStream(tempFile.getPath()+ "/" + File.separator + picName);
            // 开始读取
            while ((len = inputStream.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 完毕，关闭所有链接
            try {
                os.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return path +picName;
    }
    public static String getRandomString(String originalFilename){
        StringBuilder sb = new StringBuilder();
        sb.append(LocalDateTime.now().getYear());
        int month = LocalDateTime.now().getMonth().getValue();
        sb.append(month>=10?month:'0'+month);
        sb.append(LocalDateTime.now().getDayOfMonth());
        sb.append(Math.abs(UUID.randomUUID().getLeastSignificantBits()%1_00_00_000_000L));
        String extName = FileUtil.extName(originalFilename);
        return sb.toString()+ "." + extName;
    }


}