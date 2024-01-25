/* *********** Pledge of Honor ************************************************ *

I hereby certify that I have completed this lab assignment on my own
without any help from anyone else. I understand that the only sources of authorized
information in this lab assignment are (1) the course textbook, (2) the
materials posted at the course website and (3) any study notes handwritten by myself.
I have not used, accessed or received any information from any other unauthorized
source in taking this lab assignment. The effort in the assignment thus belongs
completely to me.
READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
SIGNATURE: <Ahmet Taha Ekim, 79234>
********************************************************************************/


package main;

import resource.*;
import java.time.LocalDate;
import research.*;

public class Main {

	public static void main(String[] args) {
		// Create New research service
		ResearchService ss = new ResearchService("KU Lib");
		
		// Create new researchers
		Researcher r1 = new Researcher("Fatmanur");
		Researcher r1Same = new Researcher("Fatmanur");
		Researcher r2 = new Researcher("Emre");
		Researcher r3 = new Researcher("Andrew");

		// Add researchers to the research service
		ss.addResearcher(r1);
		ss.addResearcher(r2);
		ss.addResearcher(r3);

		// Test of adding the existing researcher once more
		System.out.println("\nTest with the existing researcher: ");
		ss.addResearcher(r1Same);

		// Create new papers and ProeedingBook
		Paper p1 = new Paper("Natural language review", "NLP", "Batuhan Ozyurt");
		Paper p2 = new Paper("Picture restoration", "Computer vision", "Sadra Safadoost");
		Paper p3 = new Paper("Natural Language meets FL", "NLP", "Muge Kural");

		Paper p4 = new Paper("FL in Healthcare", "Distributed Networks", "Vahideh");
		Paper p5 = new Paper("Flags", "Distributed Networks", "Ahnaf");
		Paper p6 = new Paper("Blockchain meets FL", "Distributed Networks", "Abdulrezzak");
		Paper p7 = new Paper("Client selection in FL", "Distributed Networks", "Vahideh");
		
		ProceedingBook s1 = new ProceedingBook("Succession", "NLP", 30, 4);


		// Add resources to the Research service
		ss.addResource(p1);
		ss.addResource(p2);
		ss.addResource(p3);
		ss.addResource(p4);
		ss.addResource(p5);
		ss.addResource(p6);
		ss.addResource(p7);
		ss.addResource(s1);

		// Downloads
		r1.download(p1, true);
		r1.download(p2, true);
		r1.download(p3, false);
		r1.download(p4, true);
		r1.download(p5, false);
		r1.download(s1, true);
		
		r2.download(p1, true);
		r2.download(p2, true);
		r2.download(p3, true);
		r2.download(p5, true);
		r2.download(p6, true);

		
		r3.download(p1, true);
		r3.download(p2, false);
		r3.download(p3, false);
		r3.download(p4, true);
		r3.download(p5, true);
		r3.download(p6, true);
		
		System.out.println("\nTest recommending Paper by similar researcher: ");
		System.out.println(ss.recommendPaperBySimilarResearcher(r1).getTitle());
		
		System.out.println("\nTest recommending Paper by field: ");
		System.out.println(ss.recommendByField(r3).getTitle());
		
		Researcher premiup1 = new PremiumResearcher("Chuck", LocalDate.parse("2020-02-03"), 12.5, true);
		Researcher premiup2 = new PremiumResearcher("Wendy", LocalDate.parse("2018-10-03"), 130, false);
		premiup1.download(p1, true);
		premiup1.download(p2, false);
		premiup1.download(p3, false);
		premiup1.download(p4, true);
		premiup1.download(p5, true);
		premiup1.download(p6, true);
		System.out.println("\nTest fee calculation: ");
		System.out.println(((PremiumResearcher) premiup1).calculateTotalFee());
		System.out.println(((PremiumResearcher) premiup2).calculateTotalFee());
		System.out.println("\nTest similarity score calculation: ");
		System.out.println(r1.measureSimilarityWith(premiup1));
		System.out.println(premiup1.measureSimilarityWith(r1));
		// Same paper/proceedingBook statistics

		System.out.println(premiup1.measureSimilarityWith(r3));
		System.out.println(r3.measureSimilarityWith(premiup1));
		

	}
}

