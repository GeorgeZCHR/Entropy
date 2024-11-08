import java.util.ArrayList;
import java.util.List;

public class Entropy {
    private String symbols;
    private String text;
    private List<Integer> symbolsCounters = new ArrayList<>();
    private List<Double> probabilities = new ArrayList<>();
    private int allLegitSymbols = 0;

    public Entropy(String symbols, String text) {
        this.symbols = symbols;
        this.text = text;
    }

    private void process() {
        for (int i = 0; i < symbols.length(); i++) {
            symbolsCounters.add(0);
            probabilities.add(0.0);
        }
        for (int i = 0; i < text.length(); i++) {
            boolean found = false;
            for (int j = 0; j < symbols.length() && !found; j++) {
                if (text.charAt(i) == symbols.charAt(j)) {
                    symbolsCounters.set(j,symbolsCounters.get(j) + 1);
                    found = true;
                    allLegitSymbols++;
                }
            }
        }
    }

    public double produce() {
        double entropy = 0;

        process();
        for (int i = 0; i < symbolsCounters.size(); i++) {
            if (symbolsCounters.get(i) != 0) {
                double symbol = symbolsCounters.get(i) * 1.0;
                double probability = symbol / allLegitSymbols;
                probabilities.set(i,probability);
                entropy = entropy - probability * (Math.log(probability)/Math.log(2));
            }
        }
        System.out.println("Probabilities : ");
        for (int i = 0; i < symbols.length(); i++) {
            System.out.println("P(" + symbols.charAt(i) + ") = " + probabilities.get(i));
        }
        return entropy;
    }
}
/*


#define max_symbols 52//145

        int main(int argc, char** rgv)
        {
        int i, m, choice, symbols[max_symbols], all_symbols = 0;
        double entropy = 0;
        char c;
        bool is_legit = true;

        ifstream f("text1.txt");

        if (f)
        {
        for (i = 0; i < max_symbols; i++)
        {
        symbols[i] = 0;
        }
        std::cout << "The text of the file:" << endl;
        std::cout << "----------------------" << endl;
        f.get(c);
        while (c)
        {
        is_legit = true;
        if (!f.eof())
        {
        std::cout << c;
        switch (toupper(c))
        {
        case 'a':
        symbols[0]++;
        break;
        case 'b':
        symbols[1]++;
        break;
        case 'c':
        symbols[2]++;
        break;
        case 'd':
        symbols[3]++;
        break;
        case 'e':
        symbols[4]++;
        break;
        case 'f':
        symbols[5]++;
        break;
        case 'g':
        symbols[6]++;
        break;
        case 'h':
        symbols[7]++;
        break;
        case 'i':
        symbols[8]++;
        break;
        case 'j':
        symbols[9]++;
        break;
        case 'k':
        symbols[10]++;
        break;
        case 'l':
        symbols[11]++;
        break;
        case 'm':
        symbols[12]++;
        break;
        case 'n':
        symbols[13]++;
        break;
        case 'o':
        symbols[14]++;
        break;
        case 'p':
        symbols[15]++;
        break;
        case 'q':
        symbols[16]++;
        break;
        case 'r':
        symbols[17]++;
        break;
        case 's':
        symbols[18]++;
        break;
        case 't':
        symbols[19]++;
        break;
        case 'u':
        symbols[20]++;
        break;
        case 'v':
        symbols[21]++;
        break;
        case 'w':
        symbols[22]++;
        break;
        case 'x':
        symbols[23]++;
        break;
        case 'y':
        symbols[24]++;
        break;
        case 'z':
        symbols[25]++;
        break;
				*/
/*case 'α':
					symbols[26]++;
					break;
				case 'β':
					symbols[27]++;
					break;
				case 'γ':
					symbols[28]++;
					break;
				case 'δ':
					symbols[29]++;
					break;
				case 'ε':
					symbols[30]++;
					break;
				case 'ζ':
					symbols[31]++;
					break;
				case 'η':
					symbols[32]++;
					break;
				case 'θ':
					symbols[33]++;
					break;
				case 'ι':
					symbols[34]++;
					break;
				case 'κ':
					symbols[35]++;
					break;
				case 'λ':
					symbols[36]++;
					break;
				case 'μ':
					symbols[37]++;
					break;
				case 'ν':
					symbols[38]++;
					break;
				case 'ξ':
					symbols[39]++;
					break;
				case 'ο':
					symbols[40]++;
					break;
				case 'π':
					symbols[41]++;
					break;
				case 'ρ':
					symbols[42]++;
					break;
				case 'σ':
					symbols[43]++;
					break;
				case 'τ':
					symbols[44]++;
					break;
				case 'υ':
					symbols[45]++;
					break;
				case 'φ':
					symbols[46]++;
					break;
				case 'χ':
					symbols[47]++;
					break;
				case 'ψ':
					symbols[48]++;
					break;
				case 'ω':
					symbols[49]++;
					break;
				case '.':
					symbols[50]++;
					break;*//*

        case 'A':
        symbols[26]++;
        break;
        case 'B':
        symbols[27]++;
        break;
        case 'C':
        symbols[28]++;
        break;
        case 'D':
        symbols[29]++;
        break;
        case 'E':
        symbols[30]++;
        break;
        case 'F':
        symbols[31]++;
        break;
        case 'G':
        symbols[32]++;
        break;
        case 'H':
        symbols[33]++;
        break;
        case 'I':
        symbols[34]++;
        break;
        case 'J':
        symbols[35]++;
        break;
        case 'K':
        symbols[36]++;
        break;
        case 'L':
        symbols[37]++;
        break;
        case 'M':
        symbols[38]++;
        break;
        case 'N':
        symbols[39]++;
        break;
        case 'O':
        symbols[40]++;
        break;
        case 'P':
        symbols[41]++;
        break;
        case 'Q':
        symbols[42]++;
        break;
        case 'R':
        symbols[43]++;
        break;
        case 'S':
        symbols[44]++;
        break;
        case 'T':
        symbols[45]++;
        break;
        case 'U':
        symbols[46]++;
        break;
        case 'V':
        symbols[47]++;
        break;
        case 'W':
        symbols[48]++;
        break;
        case 'X':
        symbols[49]++;
        break;
        case 'Y':
        symbols[50]++;
        break;
        case 'Z':
        symbols[51]++;
        break;
				*/
/*case 'Α':
					symbols[77]++;
					break;
				case 'Β':
					symbols[78]++;
					break;
				case 'Γ':
					symbols[79]++;
					break;
				case 'Δ':
					symbols[80]++;
					break;
				case 'Ε':
					symbols[81]++;
					break;
				case 'Ζ':
					symbols[82]++;
					break;
				case 'Η':
					symbols[83]++;
					break;
				case 'Θ':
					symbols[84]++;
					break;
				case 'Ι':
					symbols[85]++;
					break;
				case 'Κ':
					symbols[86]++;
					break;
				case 'Λ':
					symbols[87]++;
					break;
				case 'Μ':
					symbols[88]++;
					break;
				case 'Ν':
					symbols[89]++;
					break;
				case 'Ξ':
					symbols[90]++;
					break;
				case 'Ο':
					symbols[91]++;
					break;
				case 'Π':
					symbols[92]++;
					break;
				case 'Ρ':
					symbols[93]++;
					break;
				case 'Σ':
					symbols[94]++;
					break;
				case 'Τ':
					symbols[95]++;
					break;
				case 'Υ':
					symbols[96]++;
					break;
				case 'Φ':
					symbols[97]++;
					break;
				case 'Χ':
					symbols[98]++;
					break;
				case 'Ψ':
					symbols[99]++;
					break;
				case 'Ω':
					symbols[100]++;
					break;
				case '0':
					symbols[101]++;
					break;
				case '1':
					symbols[102]++;
					break;
				case '2':
					symbols[103]++;
					break;
				case '3':
					symbols[104]++;
					break;
				case '4':
					symbols[105]++;
					break;
				case '5':
					symbols[106]++;
					break;
				case '6':
					symbols[107]++;
					break;
				case '7':
					symbols[108]++;
					break;
				case '8':
					symbols[109]++;
					break;
				case '9':
					symbols[110]++;
					break;
				case '`':
					symbols[111]++;
					break;
				case '~':
					symbols[112]++;
					break;
				case '!':
					symbols[113]++;
					break;
				case '@':
					symbols[114]++;
					break;
				case '#':
					symbols[115]++;
					break;
				case '$':
					symbols[116]++;
					break;
				case '%':
					symbols[117]++;
					break;
				case '^':
					symbols[118]++;
					break;
				case '&':
					symbols[119]++;
					break;
				case '*':
					symbols[120]++;
					break;
				case '(':
					symbols[121]++;
					break;
				case ')':
					symbols[122]++;
					break;
				case '-':
					symbols[123]++;
					break;
				case '_':
					symbols[124]++;
					break;
				case '=':
					symbols[125]++;
					break;
				case '+':
					symbols[126]++;
					break;
				case '[':
					symbols[127]++;
					break;
				case ']':
					symbols[128]++;
					break;
				case '{':
					symbols[129]++;
					break;
				case '}':
					symbols[130]++;
					break;
				case '\\':
					symbols[131]++;
					break;
				case '|':
					symbols[132]++;
					break;
				case ':':
					symbols[133]++;
					break;
				case ';':
					symbols[134]++;
					break;
				case '΄':
					symbols[135]++;
					break;
				case '¨':
					symbols[136]++;
					break;
				case '\'':
					symbols[137]++;
					break;
				case '"':
					symbols[138]++;
					break;
				case ',':
					symbols[139]++;
					break;
				case '<':
					symbols[140]++;
					break;
				case '>':
					symbols[141]++;
					break;
				case '/':
					symbols[142]++;
					break;
				case '?':
					symbols[143]++;
					break;*//*

default:
        is_legit = false;
        std::cout << "<--NOT_LEGIT--";
        //symbols[52]++;
        break;
        }
        if (is_legit)
        {
        all_symbols++;
        }
        f.get(c);
        }
        else
        break;
        }
        std::cout << endl << "----------------------" << endl;

        // it prints the numbers of the symbols.(for debugging)
        for (i = 0; i < max_symbols; i++)
        {
        std::cout << symbols[i] << ", ";
        }
        std::cout << endl;

		*/
/*do
		{
			std::cout << "Do you want whitespces in entropy? (yes=1/no=2)" << endl;
			std::cin >> choice;
		} while (choice < 1 || choice >2);
		switch (choice)
		{
		case 1:
			m = max_symbols;
			break;
		default :
			m = max_symbols - 1;
		}*//*


        for (i = 0; i < max_symbols; i++)
        {
        if (symbols[i] != 0)
        {
        float symbol = symbols[i] * 1.0;
        entropy = entropy - (symbol / all_symbols) * log2(symbol / all_symbols);
        }
        }
        std::cout << "The entropy of the text of the file: " << entropy << endl;


        f.close();
        }
        else
        std::cout << "File cannot be opened or does not exist!" << endl;
        return 0;
        }
*/
