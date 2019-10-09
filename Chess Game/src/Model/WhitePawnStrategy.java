package Model;

import java.util.ArrayList;

public class WhitePawnStrategy implements ChessPieceStrategy
{

	@Override
	public ArrayList<Coordinates> strategy(Coordinates coord)
	{
		ArrayList<Coordinates> possibleMoves = new ArrayList<Coordinates>();
		
		//if pawn has not moved yet, add move 2 spaces forward to move set
		if(coord.getX() == 6)
		{
			possibleMoves.add(new Coordinates(coord.getX(), coord.getY() + 2));
		}
		
		//add move 1 space forward to move set
		possibleMoves.add(new Coordinates(coord.getX(), coord.getY() + 1));
		
		//still need to add diagonal move
		
		return possibleMoves;
	}
	
}
