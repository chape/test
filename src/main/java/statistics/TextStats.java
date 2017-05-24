package statistics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextStats 
{
	static long WordsNumber;
	static long CharsNumber;
	static long LineNumber;
	static long Vowels;
	static long Consonants;
	static int AverageWordLength;
	
	public static void main(String[] arg) throws IOException{
		
		System.out.print("File name: ");
		Scanner in = new Scanner(System.in);
		String filename = in.next();
		in.close();
		
		if(!filename.endsWith(".log")) 
			filename = filename.concat(".log");
		
		long start = System.currentTimeMillis();
		System.out.println(start);

		FileReader FILE_CF = new FileReader(filename);
		BufferedReader FILE_BR = new BufferedReader(new FileReader(filename));
		StreamTokenizer FILE_ST_CWC = new StreamTokenizer(new FileReader(filename));
		StreamTokenizer FILE_ST_WF = new StreamTokenizer(new FileReader(filename));
		StreamTokenizer FILE_ST_LW = new StreamTokenizer(new FileReader(filename));

		LineCounter(FILE_BR);
		WordFrequency(FILE_ST_WF);
		CharInWordFrequency(FILE_ST_CWC);
		CharFrequency(FILE_CF);
		LongestWord(FILE_ST_LW);
		
		System.out.println("TEXT ANALYZED! Elapse(ms):"+ (System.currentTimeMillis() - start));
	}
	
	public static void LineCounter(BufferedReader input) throws IOException{
		
		while(input.readLine()!= null)
			LineNumber++;
		System.out.println("File consists of " +LineNumber+ " lines");
		System.out.println();
	}
	/**
	 * 单词的长度统计 key单词长度-value出现次数
	 * @param input
	 * @throws IOException
	 */
	public static void CharInWordFrequency(StreamTokenizer input) throws IOException{
		Map<Integer,Integer> Words = new HashMap<Integer,Integer>();
		input.whitespaceChars('!', '@');//将特殊字符和数字视为空格，具体查看ASCII码表
		input.whitespaceChars('[', '`');
		input.whitespaceChars('{', '~');
		
		while((input.nextToken())!= StreamTokenizer.TT_EOF)
		{
			Integer freq = Words.get(input.sval.length());
			Words.put(input.sval.length(), freq == null ? 1 : freq+1);
		}
		
		long div = 0;
		
		for (Map.Entry<Integer,Integer> entry : Words.entrySet()) {
			AverageWordLength += entry.getKey() * entry.getValue();
			div += entry.getValue();
		}
		
		AverageWordLength /= div;
		
		System.out.println("Average word length: " +AverageWordLength);
		System.out.println();
		System.out.println("WordLength = Occurances");
		System.out.println(Words);
		System.out.println();
	}
	/**
	 * 词频统计
	 * @param input
	 * @throws IOException
	 */
	public static void WordFrequency(StreamTokenizer input) throws IOException{
		Map<String,Integer> Words = new HashMap<String,Integer>();
		//元音
		String vowels = "[a|e|u|o|i|y|A|E|U|O|I|Y]";
		//辅音
		String consonants = "[q|w|r|t|p|s|d|f|g|h|j|k|l|z|x|c|v|b|n|m|Q|W|R|T|P|S|D|F|G|H|J|K|L|Z|X|C|V|B|N|M]";
		Pattern pattern;
		Matcher matcher;
		input.whitespaceChars('!', '@');
		input.whitespaceChars('[', '`');
		input.whitespaceChars('{', '~');
		
		while((input.nextToken())!= StreamTokenizer.TT_EOF)
		{
			WordsNumber++;
			pattern = Pattern.compile(vowels);
			matcher = pattern.matcher(input.sval);
			
			while(matcher.find()) 
				Vowels++;
			
			pattern = Pattern.compile(consonants);
			matcher = pattern.matcher(input.sval);
			
			while(matcher.find())
				Consonants++;
			
			Integer freq = Words.get(input.sval);
			Words.put(input.sval, freq == null ? 1 : freq+1);
		}
		System.out.println(Words);
		System.out.println();
		System.out.println("File contains " +WordsNumber+ " words");
//		Finder(Words);
	}
	/**
	 * 字符频率统计
	 * @param input
	 * @throws IOException
	 */
	public static void CharFrequency(FileReader input) throws IOException{
		
		Map<Integer,Integer> Chars = new HashMap<Integer,Integer>();
		Integer c;
		while((c = input.read()) != -1)
		{
			CharsNumber++;
			Integer freq = Chars.get(c);
			Chars.put(c, freq == null ? 1 : freq+1);
		}
		
		System.out.println("File contains " +CharsNumber+ " characters [ " +Vowels+ " - vowels, " +Consonants+ " - consonants ]");
		System.out.println();
		for(char i='a'; i<='z'; i++)
		System.out.println("Number of " +i+ " characters: " +Chars.get((int)i));
		System.out.println();
	}
	
	public static void LongestWord(StreamTokenizer input) throws IOException{
		
		ArrayList<String> LWordsList = new ArrayList<String>();
		ArrayList<String> SWordsList = new ArrayList<String>();
		
		String LWord = null,  SWord = null, LongWord = null, ShortWord = null;
		
		int Llength = 0, Slength = 40;
		
		input.whitespaceChars('!', '@');
		input.whitespaceChars('[', '`');
		input.whitespaceChars('{', '~');
		
		while((input.nextToken())!= StreamTokenizer.TT_EOF)
		{
			LWord = input.sval;
			SWord = input.sval;
			if(input.sval == null) continue;
			
			if(LWord.length()==Llength)
				if(!LWordsList.contains(LWord))
				{
					LWordsList.add(LWord);
				}
			if(LWord.length()>Llength)
			{
				LongWord = LWord;
				LWordsList.clear();
				LWordsList.add(LongWord);
				Llength = LongWord.length();
			}
			if(SWord.length()==Slength)
				if(!SWordsList.contains(SWord))
				{
					SWordsList.add(SWord);
				}
			
			if(SWord.length()<Slength)
			{
				ShortWord = SWord;
				SWordsList.clear();
				SWordsList.add(ShortWord);
				Slength = ShortWord.length();
			}
		}
		
		System.out.println("The longest word/s consists of " +LongWord.length()+ " character/s and are/is the following: ");
		System.out.println(LWordsList);
		System.out.println();
		System.out.println("The shortest word/s consists of " +ShortWord.length()+ " character/s and are/is the following: ");
		System.out.println(SWordsList);
		System.out.println();
	}
	
	public static void Finder(Map<String,Integer> Words){
		
		System.out.println("Insert word");
		Scanner in = new Scanner(System.in);
		String word = in.next();
		in.close();
		if(Words.containsKey(word)) System.out.println("Found " + Words.get(word) + " occurance/s of word " + word);
		else System.out.println("File does not contain specified word");
	}
	
}
