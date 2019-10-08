import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChessBoard extends JPanel
{
	private JButton[][] board;
	ChessPieceImage chessPieceImage;
	
	public ChessBoard()
	{
		try
		{
			chessPieceImage = new ChessPieceImage();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		setLayout(new GridBagLayout());
		buildBoardButtons();
		
		displayImg();
	}
	
	private void buildBoardButtons()
	{
		int boardArraySize = 8;
		int squareEdgeLength = 200;
		this.board = new JButton[boardArraySize][boardArraySize];
		GridBagConstraints gc = new GridBagConstraints();
		
		for(int i=0; i < board.length; i++)
		{
			gc.gridx = i;
			
			for(int j=0; j < board[i].length; j++)
			{
				gc.gridy = j;
				
				this.board[i][j] = new JButton();
				this.board[i][j].setPreferredSize(new Dimension(squareEdgeLength,
						squareEdgeLength));
				
//				this.board[i][j].setFont(this.board[i][j].getFont().deriveFont(40f));
//				this.board[i][j].setText(String.format("%d, %d", i, j));
				
				if((i+j)%2 == 0)
				{
					this.board[i][j].setBackground(new Color(203, 150, 111));
				}
				else
				{
					this.board[i][j].setBackground(new Color(106, 58, 38));
				}
				this.add(this.board[i][j], gc);
			}
		}
	}
	
	//DELETE Later
	private void displayImg()
	{
		try
		{
			Image image = ImageIO.read(getClass().getResource("/black-king.png"));
			image = image.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH );
			this.board[0][0].setIcon(new ImageIcon(image));
			this.board[0][1].setIcon(new ImageIcon(image));
		}
		catch(Exception e)
		{
			System.out.println("Failed");
		}
	}
}
