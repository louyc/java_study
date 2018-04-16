package lyc.qrCode;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QrCodeCreateUtil {

	/**
	 * 生成包含字符串信息的二维码图片
	 * 
	 * @param outputStream
	 *            文件输出流路径
	 * @param content
	 *            二维码携带信息
	 * @param qrCodeSize
	 *            二维码图片大小
	 * @param imageFormat
	 *            二维码的格式
	 * @throws WriterException
	 * @throws IOException
	 */
	public static boolean createQrCode(OutputStream outputStream, String content, int qrCodeSize,
			String imageFormat) throws WriterException, IOException {
		// 设置二维码纠错级别ＭＡＰ
		Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<EncodeHintType, ErrorCorrectionLevel>();
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L); // 矫错级别
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		// 创建比特矩阵(位矩阵)的QR码编码的字符串
		BitMatrix byteMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, qrCodeSize,
				qrCodeSize, hintMap);
		// 使BufferedImage勾画QRCode (matrixWidth 是行二维码像素点)
		int matrixWidth = byteMatrix.getWidth();
		BufferedImage image = new BufferedImage(matrixWidth - 200, matrixWidth - 200,
				BufferedImage.TYPE_INT_RGB);
		image.createGraphics();
		Graphics2D graphics = (Graphics2D) image.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, matrixWidth, matrixWidth);
		// 使用比特矩阵画并保存图像
		graphics.setColor(Color.BLACK);
		for (int i = 0; i < matrixWidth; i++) {
			for (int j = 0; j < matrixWidth; j++) {
				if (byteMatrix.get(i, j)) {
					graphics.fillRect(i - 100, j - 100, 1, 1);
				}
			}
		}
		return ImageIO.write(image, imageFormat, outputStream);
	}

	/**
	 * v读二维码并输出携带的信息
	 */
	public static void readQrCode(InputStream inputStream) throws IOException {
		// 从输入流中获取字符串信息
		BufferedImage image = ImageIO.read(inputStream);
		// 将图像转换为二进制位图源
		LuminanceSource source = new BufferedImageLuminanceSource(image);
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
		QRCodeReader reader = new QRCodeReader();
		Result result = null;
		try {
			result = reader.decode(bitmap);
		} catch (ReaderException e) {
			e.printStackTrace();
		}
		System.out.println(result.getText());
	}

	/**
	 * 测试代码
	 * 
	 * @throws WriterException
	 */
	/**
	 * main:(这里用一句话描述这个方法的作用). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 * 
	 * @param args
	 * @throws IOException
	 * @throws WriterException
	 *             void
	 * @exception
	 * @author lyc
	 */
	public static void main(String[] args) throws IOException, WriterException {

		createQrCode(new FileOutputStream(new File("F:\\1.png")), "http://172.168.1.1:123", 900,
				"JPEG");
		readQrCode(new FileInputStream(new File("F:\\1.png")));
	}
}
