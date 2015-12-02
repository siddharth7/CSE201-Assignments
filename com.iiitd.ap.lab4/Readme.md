1. You have been provided with a csv file that contains the details of a number of articles.
2. The format of CSV FILE: Author Name,Paper Title,Journal Name,Year of Publication
3. Assume that ‘,’ is only used as a separator and nowhere else
4. Make sure that the path of the file while reading is set to this: ./src/output.csv
5. This implies, place the provided csv file directly in the src folder of your project
6. You have been provided with a JUnit test file to test your program
7. You have been provided with javadoc for Hashmap, in case you need help.
Your task is to write a program in java that
 Can read the content from the file (preferably line wise)
 For given pair of authors in the test cases, it should return the title of the article(s) that
is/are co-authored by them.
o Soyourmethod(calledcoauthored)shouldtaketwostringsasthearguments-
author1 and author2
o ThereturntypeofyourfunctionshouldbeanArrayListofStringwhichcontainsthe
Title of the articles co-authored by the pair. If no such article exists then return an
empty arraylist.
o ImagineitasamappingrelationfromasetofAuthorstosetofArticlesandforgiven
pair of authors check their mapping to set of Articles to look out for common article.(Hint: You could use ArrayList or Hashmap to maintain such relation, however it is upto to you if you want to make use of any collection)
You have already worked extensively with ArrayList, however, if you need help with using Hashmap, the TAs are there for help and you have been provided with the javadoc for Hashmap.
o Trytomakeyourprogramasefficientaspossiblesothatitisscalableenoughto process a file of upto 5000 entries as the additional test file to be used for evaluation maybe of large size and your program should be able to process and output the results in least possible time.
 You are free to design your class anyway you want but it should contain this described method
ArrayList<String> coauthored(String author1, String author2)
Name your class as DBLP
 You have been provided with the Junit Test file to test some of the cases. Design your program such that is passes these tests
