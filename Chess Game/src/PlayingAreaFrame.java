import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

public class PlayingAreaFrame extends JFrame
{
	public PlayingAreaFrame()
	{
		super("Chess Game");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		ChessBoard chessBoard = new ChessBoard();
		
		Container pane = this.getContentPane();
		pane.add(chessBoard, BorderLayout.CENTER);
		
		pack();
		setVisible(true);
	}
	
}
