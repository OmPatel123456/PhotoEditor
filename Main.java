public class MainPhoto {

	public static void main(String[] args) {
		
		Image Image1 = new Image("/Users/ompatel/Desktop/AnimeImage.jpeg");
		
		Image1.readIn();
		
		Image1.Brighten(100);
		Image1.Darken(100);
		
		Image1.Output("/Users/ompatel/Desktop/AnimeImageOutput.jpeg");
		
		Image Image2 = new Image("/Users/ompatel/Desktop/Itachi.jpeg");
		
		Image2.readIn();
		
		Image2.Brighten(50);
		Image2.Darken(50);
		
		Image2.Output("/Users/ompatel/Desktop/ItachiOutput.jpeg");

	}

}
