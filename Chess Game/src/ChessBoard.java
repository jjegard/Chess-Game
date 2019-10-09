import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.ChessPiece;
import Model.Coordinates;
import Model.WhitePawnStrategy;

public class ChessBoard extends JPanel
{
	private JButton[][] board;
	private ChessPieceImage chessPieceImage;
	private ChessPiece piece;
	
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
		
		//delete later
		piece = new ChessPiece("white", "pawn", chessPieceImage.getWhiteChessPieces()[0],
				new WhitePawnStrategy(), new Coordinates(6,2));
		moveChessPiece(piece);

//		displayImg();
	}
	
	
	/**
	 * This creates the board buttons. The reason that I am using
	 * [board[i].length-1-j] as the 2nd array index value in the for loop
	 * is to generate the board so that the buttons follow the cartesian coordinate
	 * system where (0, 0) is the bottom left corner.
	 * 
	 * (7,0) (7,1) (7,2) (7,3) (7,4), (7,5) (7,6) (7,7)
	 * (6,0) (6,1) (6,2) (6,3) (6,4), (6,5) (6,6) (6,7)
	 * (5,0) (5,1) (5,2) (5,3) (5,4), (5,5) (5,6) (5,7)
	 * (4,0) (4,1) (4,2) (4,3) (4,4), (4,5) (4,6) (4,7)
	 * (3,0) (3,1) (3,2) (3,3) (3,4), (3,5) (3,6) (3,7)
	 * (2,0) (2,1) (2,2) (2,3) (2,4), (2,5) (2,6) (2,7)
	 * (1,0) (1,1) (1,2) (1,3) (1,4), (1,5) (1,6) (1,7)
	 * (0,0) (0,1) (0,2) (0,3) (0,4), (0,5) (0,6) (0,7)
	 */
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
				
				this.board[i][board[i].length-1-j] = new JButton();
				this.board[i][board[i].length-1-j].setPreferredSize(new Dimension(
						squareEdgeLength, squareEdgeLength));
				
				//this prints the button's coordinates on top of each button
//				this.board[i][board[i].length-1-j].setFont(
//						this.board[i][board[i].length-1-j].getFont().deriveFont(40f));
//				this.board[i][board[i].length-1-j].setText(String.format(
//						"%d, %d", i, board[i].length-1-j));
				
				if((i+board[i].length-1-j)%2 == 0)
				{
					this.board[i][board[i].length-1-j].setBackground(
							new Color(203, 150, 111));
				}
				else
				{
					this.board[i][board[i].length-1-j].setBackground(
							new Color(106, 58, 38));
				}
				this.add(this.board[i][board[i].length-1-j], gc);
			}
		}
	}
	
	//DELETE Later, this just shows the code in order to display img on JButton
	private void displayImg()
	{
		ImageIcon img = this.chessPieceImage.getWhiteChessPieces()[0];
		this.board[6][1].setIcon(img);
	}
	
	//DELETE Later, this just shows that I am able to control the positioning of the
	//chess piece using the strategy pattern
	private void moveChessPiece(ChessPiece piece)
	{
		board[piece.getCoordinates().getX()][piece.getCoordinates().getY()].setIcon(
				piece.getImg());
		System.out.println(piece);
		
		ArrayList<Coordinates> newPosition = piece.getStrategy().strategy(
				piece.getCoordinates());
		
		
		System.out.println(newPosition);
		board[piece.getCoordinates().getX()][piece.getCoordinates().getY()].setIcon(null);
		piece.setCoordinates(newPosition.get(0));
		System.out.println(piece);
		board[piece.getCoordinates().getX()][piece.getCoordinates().getY()].setIcon(
				piece.getImg());
	}
}
