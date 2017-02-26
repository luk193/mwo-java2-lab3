package pl.edu.agh.mwo.java.crawler;

import java.io.IOException;
import java.net.MalformedURLException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Crawler {

	protected String urlToProcess;

	public Crawler(String initUrl) throws MalformedURLException {
		urlToProcess = initUrl;
	}

	public void run() throws IOException {

		Document doc = null;
		doc = Jsoup.connect(urlToProcess).get();

		String text = doc.body().text();

		String[] sentences = text.split("\\.");

		char charToFind = 'p';
		String sentence = "Bruksela";

		for (int i = 0; i < sentences.length; i++) {
			int charCount = 0;
			for (int j = 0; j < sentences[i].length(); j++) {

				if (sentences[i].charAt(j) == charToFind) {
					charCount++;
				}

			}
			if (charCount > 5) {
				System.out.println(sentences[i]);
			}

			// if (sentences[i].contains(sentence)) {
			// System.out.println(sentences[i]);
			// }
			////////// ??

		}

	}
}
