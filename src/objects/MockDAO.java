package objects;

import java.util.ArrayList;
import java.util.List;

public class MockDAO {
	private List<Product> productList;
	private List<Description> descriptionList;


	/**
	 *  A mock database with a group of three predefined products and descriptions.
	 */
	public MockDAO() {
		productList = new ArrayList<Product>();
		descriptionList = new ArrayList<Description>();

		Product product1 = new Product(1, "Small Gods", 11.00, "small-gods.jpg");
		Product product2 = new Product(2, "Ready Player One", 21.50,
				"ready-player-one.jpg");
		Product product3 = new Product(3, "War of the Worlds", 27.00,
				"war-of-the-worlds.jpg");

		Description description1 = new Description(1, 9782124957335L, "");
		Description description2 = new Description(2, 9783546897376L, "");
		Description description3 = new Description(3, 9789033438378L, "");
		// int numb, long code, String descr

		description1
				.setText("Brutha is the Chosen One."
						+ "His god has spoken to him, admittedly while currently in the shape of a tortoise."
						+ "Brutha is a simple lad. He can't read. He can't write. He's pretty good at growing melons. And his wants are few."
						+ "He wants to overthrow a huge and corrupt church."
						+ "He wants to prevent a horrible holy war."
						+ "He wants to stop the persecution of a philosopher who has dared to suggest that, contrary to the Church's dogma, the Discworld really does go through space on the back of an enormous turtle (*)."
						+ "He wants peace and justice and brotherly love. He wants the Inquisition to stop torturing him now, please."
						+ "But most of all, what he really wants, more than anything else, is for his god to Choose Someone Else ..."
						+ "(* which is true, but when has that ever mattered?)");
		description2
				.setText("In the year 2044, reality is an ugly place. "
						+ "The only time teenage Wade Watts really feels alive is when he's jacked into the virtual utopia known as the OASIS. "
						+ "Wade's devoted his life to studying the puzzles hidden within this world's digital confines—puzzles that are based on "
						+ "their creator's obsession with the pop culture of decades past and that promise massive power and fortune to whoever can unlock them. "
						+ "But when Wade stumbles upon the first clue, he finds himself beset by players willing to kill to take this ultimate prize. "
						+ "The race is on, and if Wade's going to survive, he'll have to win—and confront the real world he's always been so desperate to escape.");
		description3.setText("H. G. Wells' classic vision of interplanetary warfare and a Martian invasion of Earth.");

		productList.add(product1);
		productList.add(product2);
		productList.add(product3);

		descriptionList.add(description1);
		descriptionList.add(description2);
		descriptionList.add(description3);
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public List<Description> getDescriptionList() {
		return descriptionList;
	}

	public void setDescriptionList(List<Description> descriptionList) {
		this.descriptionList = descriptionList;
	}
}
