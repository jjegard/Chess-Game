import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ChessPieceImage
{
	private ImageIcon[] blackChessPieces;
	private ImageIcon[] whiteChessPieces;
	
	public ChessPieceImage() throws IOException
	{
		blackChessPieces = new ImageIcon[6];
		whiteChessPieces = new ImageIcon[6];
		
		String[] blackSrc = new String[6];
		String[] whiteSrc = new String[6];
		
		blackSrc[0] = "/black-pawn.png";
		blackSrc[1] = "/black-rook.png";
		blackSrc[2] = "/black-knight.png";
		blackSrc[3] = "/black-bishop.png";
		blackSrc[4] = "/black-queen.png";
		blackSrc[5] = "/black-king.png";
		
		whiteSrc[0] = "/white-pawn.png";
		whiteSrc[1] = "/white-rook.png";
		whiteSrc[2] = "/white-knight.png";
		whiteSrc[3] = "/white-bishop.png";
		whiteSrc[4] = "/white-queen.png";
		whiteSrc[5] = "/white-king.png";
		
		readChessPieceImageFromFile(blackSrc, this.blackChessPieces);
		readChessPieceImageFromFile(whiteSrc, this.whiteChessPieces);
	}
	
	private void readChessPieceImageFromFile(String[] colorSrc, ImageIcon[] chessPieces)
			throws IOException
	{
		for(int i=0; i < colorSrc.length; i++)
		{
			Image image = ImageIO.read(getClass().getResource(colorSrc[i]));
			image = image.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH );
			chessPieces[i] = new ImageIcon(image);
		}
	}
	
	public ImageIcon[] getBlackChessPieces()
	{
		return this.blackChessPieces;
	}
	
	public ImageIcon[] getWhiteChessPieces()
	{
		return this.whiteChessPieces;
	}
}
