package mvntest;

import apple.awt.CToolkit;
import com.alibaba.fastjson.JSONObject;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.apache.commons.io.IOUtils;
import sun.awt.image.ToolkitImage;
import sun.java2d.SunGraphics2D;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.List;

/**
 * Hello world!
 */
public class App {

    /**
     * 编码
     *
     * @param contents
     * @param width
     * @param height
     * @param file
     */
    public static void encode(String contents, int width, int height, File file) throws IOException {



        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
        // 指定纠错等级
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        // 指定编码格式
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(contents,
                    BarcodeFormat.QR_CODE, width, height, hints);

            MatrixToImageWriter.writeToFile(bitMatrix, "png", file);
        } catch (Exception e) {
            e.printStackTrace();
        }

       /* Image image = Toolkit.getDefaultToolkit().getImage("/Users/john/temp/meeting.jpg");
        Image image2 = new BufferedImage(image.getWidth(), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Image image3 = Toolkit.getDefaultToolkit().getImage(file.getAbsolutePath());
        Graphics graphics = image2.getGraphics();
        graphics.drawImage(image3, 170, 610, new ImageObserver() {
            @Override
            public boolean imageUpdate(Image image, int i, int i2, int i3, int i4, int i5) {
                return false;
            }
        });*/
    }

    /**
     * @param args
     */
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("file.encoding"));

        List<MeetingRoom> meetingRoomList = readRoomList();
        if (meetingRoomList != null && meetingRoomList.size() > 0) {
            int i = 0;
            List<Integer> excludeAreaIdList = Arrays.asList(1, 2, 3, 5, 6);

            for (MeetingRoom meetingRoom : meetingRoomList) {
                if (i > 0) {
                    //return;
                }

                int areaId = meetingRoom.getAreaId();
                if (excludeAreaIdList.contains(areaId)) {
                    continue;
                }

                String imgPath = "/Users/john/temp/meeting/" + meetingRoom.getRoomId() + "-" + meetingRoom.getRoomName().split(" ")[0] + ".png";
                String contents = "{roomId:" + meetingRoom.getRoomId() + "}";
                int width = 590, height = 590;
                File file = new File(imgPath);
                if (!file.exists()) {
                    file.createNewFile();
                }
                encode(contents, width, height, file);

                i++;
            }
        }
        System.out.println("done");
    }


    public static List<MeetingRoom> readRoomList() throws IOException {
        InputStream inputStream = new FileInputStream("/Users/john/workspace3/mvntest/src/main/json");
        String str = IOUtils.toString(inputStream);

        JsonData jsonData = JSONObject.parseObject(str, JsonData.class);

        return jsonData.getData();
    }
}
