import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

public class PlayingAreaFrame extends JFrame
{
	private ChessBoard chessBoard;
	
	public PlayingAreaFrame()
	{
		super("Chess Game");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		chessBoard = new ChessBoard();
		
		Container pane = this.getContentPane();
		pane.add(chessBoard, BorderLayout.CENTER);
		
		pack();
		setVisible(true);
	}
	
}
