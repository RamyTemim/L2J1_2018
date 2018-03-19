package morpion;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.List;


public class Grille {
public static  final int  NB_ROWS =3;
public static final int NB_COLUMNS =3;

private static Tile [][] cases ;
public Grille () {
	
	cases = new Tile[NB_ROWS][NB_COLUMNS];
	for( int rowIndex =0 ; rowIndex < NB_ROWS ; rowIndex++) {
		for (int columnIndex =0 ;columnIndex < NB_COLUMNS;columnIndex ++) {
			cases[rowIndex][columnIndex]= new Tile (rowIndex,columnIndex);
		}
	}
}
/**
 * @param tileId string format "rowId-columnId"
 * 
 * @throws NullPointerException if tileId is null
 * @throws ArrayIndexOutOfBoundsException if tileId has an out of bounds rowIndex or columnIndex
 */

 public Tile get(String caseId)
 {
	 /// deviser le string en deux partie par le "-"
	 String [] indices = caseId.split("-");
	 if (indices.length != 2)
	 {
		 return null;
	 }
	 int rowIndex = Integer.valueOf(indices[0]);
	 int columnIndex = Integer.valueOf(indices[1]);
	 return get(rowIndex,columnIndex); // fait appelle a la fonction en dessuus 
	 
 }
 /**
	 * @throws ArrayIndexOutOfBoundsException if rowIndex or columnIndex are out of bounds
	 */
 /////  return les indices de la case 
	public Tile get( int rowIndex, int columnIndex ) {
		return cases[ rowIndex ][ columnIndex ];
	}
	
	/// renvoie une case valide
	public Tile getRandomAvailable() {
	  List<Tile> available = new ArrayList<>();
	  
		for(Tile [] row :cases )
		{
			for (Tile cas : row  )
			{
				if (cas.isEmpty())
					available.add(cas);
			}
		}
		if (available.isEmpty())
			
			return null;
		
		/// generer un nombre entre 0 et available.size
		int randomNum = new Random().nextInt(available.size());
		
		return available.get(randomNum);
	}
	
	
	/// verifier si tout la grille est plein 
	public static boolean isFull() 
	{
		for ( Tile[] row : cases )
		{
			for ( Tile cas : row )
			{
				if( cas.isEmpty() ) 
					return false;
				
			}
		}
		
		return true;
	}
	//// retourner tout les cases 
	public Tile[][] getCases() {
		return cases;
	}
	/// recupere les  case d une line 
	public List<Tile> getRow( int rowIndex ) {
		return Arrays.asList( cases[ rowIndex ] );
	}
	/// recuperer les case d une colomne 
	public List<Tile> getColumn( int columnIndex ) {
		List<Tile> column = new ArrayList<>();

		for ( Tile[] row : cases  ) {
			column.add( row[ columnIndex ] );
		}

		return column;
	}
	///// recupere les case de la diagonale 753 
	public List<Tile> getDiagonalLeftTopBottomRight() {
		return Arrays.asList( get( 0, 0 ), get( 1, 1 ), get( 2, 2 ) );
	}
///// recupere les case de la diagonale 951
	public List<Tile> getDiagonalRightTopBottomLeft() {
		return Arrays.asList( get( 0, 2 ), get( 1, 1 ), get( 2, 0 ) );
	}
	//// recuperer tout les lines de la grille soit diagonale soit verticale ou horizentale 
	public List<List<Tile>> getAllLines() {
		List<List<Tile>> lines = new ArrayList<>();

		for ( int i = 0; i < NB_ROWS; i++ )
		{
			lines.add( getRow( i ) );
		}

		for ( int j = 0; j < NB_COLUMNS; j++ ) 
		{
			lines.add( getColumn( j ) );
		}

		lines.add( getDiagonalLeftTopBottomRight() );
		lines.add( getDiagonalRightTopBottomLeft() );

		return lines;
	}
	///// re-intialiser al grille de morpion ;
	public void reset() {
		for ( Tile[] row : cases ) {
			for ( Tile tile : row ) {
				tile.setValue( Tile.Value.EMPTY );
			}
		}
	}
	

 
}
