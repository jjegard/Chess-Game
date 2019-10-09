package Model;

import javax.swing.ImageIcon;

public class ChessPiece
{
	private final String TEAM; //black or white
	private String piece;//the piece name such as pawn or rook
	private ImageIcon img; //the ImageIcon corresponding to the piece and team
	private ChessPieceStrategy strategy; //the moveset of this ChessPiece
	private Coordinates coord;
	
	public ChessPiece(String team, String piece, ImageIcon img, ChessPieceStrategy strategy,
			Coordinates coord)
	{
		this.TEAM = team;
		this.piece = piece;
		this.img = img;
		this.strategy = strategy;
		this.coord = coord;
	}
	
	public String getTeam()
	{
		return this.TEAM;
	}
	
	public String getPiece()
	{
		return this.piece;
	}
	
	public void setPiece(String piece)
	{
		this.piece = piece;
	}
	
	public ImageIcon getImg()
	{
		return this.img;
	}
	
	public void setImg(ImageIcon img)
	{
		this.img = img;
	}
	
	public ChessPieceStrategy getStrategy()
	{
		return strategy;
	}
	
	public void setStrategy(ChessPieceStrategy strategy)
	{
		this.strategy = strategy;
	}

	public Coordinates getCoordinates()
	{
		return this.coord;
	}

	public void setCoordinates(Coordinates coord)
	{
		this.coord = coord;
	}
	
	@Override
	public String toString()
	{
		return String.format("Team: %s, Piece: %s, %s", this.TEAM, this.piece, this.coord);
	}
}
