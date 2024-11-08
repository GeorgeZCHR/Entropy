import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class EntropyFrame extends JFrame {
    private int width, height;
    private boolean onlyReadable = true;
    private boolean upperLower = true;
    private boolean lower = false;
    private boolean upper = false;
    private JLabel infoLabel;
    private JLabel entropySymbolsLabel = new JLabel("Entropy's Symbols Text : ");
    private JButton entropySymbolsButton = new JButton("Add");
    private JLabel textForTestingLabel = new JLabel("Text for testing : ");
    private JButton textForTestingButton = new JButton("Add");
    private JTextArea symbolsTextArea = new JTextArea();
    private JTextArea testingTextArea = new JTextArea();
    private JLabel entropyLabel = new JLabel("Entropy : ");
    private JTextField entropyResult = new JTextField();
    private JScrollPane entropySymbolsSP;
    private JScrollPane textForTestingSP;
    private JButton calculateButton = new JButton("Calculate");
    private JRadioButton readableButton = new JRadioButton("Readable");
    private JRadioButton writableButton = new JRadioButton("Writable");
    private JRadioButton upperButton = new JRadioButton("Only Upper letters");
    private JRadioButton lowerButton = new JRadioButton("Only Lower letters");
    private JRadioButton upperLowerButton = new JRadioButton("Upper and Lower letters");

    public EntropyFrame() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = screenSize.width;
        height = (int) (0.9 * screenSize.height);

        setTitle("Entropy");
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        infoLabel = new JLabel("Add the symbols for entropy and the text for"
                + " testing and you are ready to go!");
        infoLabel.setBounds((int) (0.02 * width), (int) (0.04 * height),
                (int) (0.75 * width), 50);

        entropySymbolsLabel.setBounds((int) (0.02 * width), (int) (0.14 * height),
                (int) (0.14 * width), 50);
        entropySymbolsButton.setBounds((int) (0.16 * width), (int) (0.14 * height),
                (int) (0.25 * width), 50);
        entropySymbolsButton.setFocusable(false);
        entropySymbolsButton.addActionListener(
                e -> symbolsTextArea.setText(readUniqueCharsFromTXTFile(openFile())));

        textForTestingLabel.setBounds((int) (0.02 * width), (int) (0.24 * height),
                (int) (0.14 * width), 50);
        textForTestingButton.setBounds((int) (0.16 * width), (int) (0.24 * height),
                (int) (0.25 * width), 50);
        textForTestingButton.setFocusable(false);
        textForTestingButton.addActionListener(
                e -> testingTextArea.setText(readFromTXTFile(openFile())));

        ButtonGroup readWriteGroup = new ButtonGroup();
        readWriteGroup.add(readableButton);
        readWriteGroup.add(writableButton);

        readableButton.setBounds((int) (0.18 * width), (int) (0.7 * height),
                (int) (0.1 * width), 50);
        readableButton.addActionListener(e -> {
            symbolsTextArea.setEnabled(false);
            testingTextArea.setEnabled(false);
        });
        readableButton.setFocusable(false);
        readableButton.setSelected(true);

        writableButton.setBounds((int) (0.18 * width), (int) (0.8 * height),
                (int) (0.1 * width), 50);
        writableButton.addActionListener(e -> {
            symbolsTextArea.setEnabled(true);
            testingTextArea.setEnabled(true);
        });
        writableButton.setFocusable(false);

        ButtonGroup upperLowerGroup = new ButtonGroup();
        upperLowerGroup.add(upperLowerButton);
        upperLowerGroup.add(upperButton);
        upperLowerGroup.add(lowerButton);

        upperLowerButton.setBounds((int) (0.02 * width), (int) (0.6 * height),
                (int) (0.15 * width), 50);
        upperLowerButton.addActionListener(e -> {
            upperLower = true;
            upper = false;
            lower = false;
        });
        upperLowerButton.setFocusable(false);
        upperLowerButton.setSelected(true);

        upperButton.setBounds((int) (0.02 * width), (int) (0.7 * height),
                (int) (0.15 * width), 50);
        upperButton.addActionListener(e -> {
            upperLower = false;
            upper = true;
            lower = false;
        });
        upperButton.setFocusable(false);

        lowerButton.setBounds((int) (0.02 * width), (int) (0.8 * height),
                (int) (0.15 * width), 50);
        lowerButton.addActionListener(e -> {
            upperLower = false;
            upper = false;
            lower = true;
        });
        lowerButton.setFocusable(false);

        calculateButton.setBounds((int) (0.22 * width), (int) (0.34 * height),
                (int) (0.19 * width), 50);
        calculateButton.setFocusable(false);
        calculateButton.addActionListener(e -> {
            String symbols = symbolsTextArea.getText();
            String testText = testingTextArea.getText();
            if (upperLower) {
                symbols = symbols.toLowerCase();
                testText = testText.toLowerCase();
            } else if (upper) {
                symbols = symbols.toUpperCase();
            } else if (lower) {
                symbols = symbols.toLowerCase();
            }
            Entropy entropy = new Entropy(symbols, testText);
            entropyResult.setText(String.valueOf(entropy.produce()));
        });

        entropyLabel.setBounds((int) (0.02 * width), (int) (0.44 * height),
                (int) (0.25 * width), 50);
        entropyResult.setBounds((int) (0.16 * width), (int) (0.44 * height),
                (int) (0.25 * width), 50);
        entropyResult.setEnabled(false);
        entropyResult.setDisabledTextColor(Color.BLACK);

        symbolsTextArea.setEnabled(false);
        symbolsTextArea.setDisabledTextColor(Color.BLACK);
        entropySymbolsSP = new JScrollPane(symbolsTextArea);
        entropySymbolsSP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        entropySymbolsSP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        entropySymbolsSP.setBounds((int) (0.42 * width), (int) (0.04 * height),
                (int) (0.56 * width), (int) (0.2 * height));

        testingTextArea.setEnabled(false);
        testingTextArea.setDisabledTextColor(Color.BLACK);
        textForTestingSP = new JScrollPane(testingTextArea);
        textForTestingSP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        textForTestingSP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        textForTestingSP.setBounds((int) (0.42 * width), (int) (0.25 * height),
                (int) (0.56 * width), (int) (0.68 * height));

        add(infoLabel);
        add(entropySymbolsLabel);
        add(entropySymbolsButton);
        add(textForTestingLabel);
        add(textForTestingButton);
        add(calculateButton);
        add(entropyLabel);
        add(entropyResult);
        add(entropySymbolsSP);
        add(textForTestingSP);
        add(upperLowerButton);
        add(upperButton);
        add(lowerButton);
        add(readableButton);
        add(writableButton);


        setLocationRelativeTo(null);
        setVisible(true);
    }

    String openFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            return selectedFile.getAbsolutePath();
        }
        return null;
    }

    String readFromTXTFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int character;
            String content = "";
            while ((character = reader.read()) != -1) {
                content = content + (char)(character);
            }
            return content;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    String readUniqueCharsFromTXTFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int character;
            String content = "";
            while ((character = reader.read()) != -1) {
                if (!content.contains(String.valueOf((char)character))) {
                    content = content + (char)(character);
                }
            }
            return content;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
