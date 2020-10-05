package week04;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class RadioCalc extends JFrame implements ItemListener {
	
	JTextField f1, f2;
	String[] items = {"+", "-", "×", "÷"};
	JRadioButton[] radios = new JRadioButton[items.length];
	JLabel lbl;
	
	public RadioCalc() {
		setTitle("라디오버튼 계산기");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		
		f1 = new JTextField(10); 
		f2 = new JTextField(10);
		
		p1.add(f1); p1.add(f2);
		
		ButtonGroup group = new ButtonGroup();
		
		for (int i = 0; i < items.length; i++) {
			radios[i] = new JRadioButton(items[i]);
			radios[i].addItemListener(this);
			group.add(radios[i]);
			p2.add(radios[i]);
		}
		
		Font font = new Font("맑은 고딕", Font.BOLD, 25);
		lbl = new JLabel();
		lbl.setFont(font);
		
		add(p1, "North");
		add(p2, "Center");
		add(lbl, "South");
		
		setBounds(1000, 200, 300, 200);
		setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		double d1 = Double.parseDouble(f1.getText());
		double d2 = Double.parseDouble(f2.getText());
		double d3 = 0;
		
		if(radios[0].isSelected()) {		
			d3 = d1 + d2;
			lbl.setText(d1 + " + " + d2 + " = " + d3);
		}
		if(radios[1].isSelected()) {		
			d3 = d1 - d2;
			lbl.setText(d1 + " - " + d2 + " = " + d3);
		}
		if(radios[2].isSelected()) {		
			d3 = d1 * d2;
			lbl.setText(d1 + " × " + d2 + " = " + d3);
		}
		if(radios[3].isSelected()) {		
			d3 = d1 / d2;
			lbl.setText(d1 + " / " + d2 + " = " + d3);
		}

	}

	public static void main(String[] args) {
		new RadioCalc();

	}

}
