package week04;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class RadioTest extends JFrame implements ItemListener {
	JTextArea ta;
	String[] radioItems = {"요거트", "아이스크림", "아메리카노", "카페라떼", "과일"};
	JRadioButton[] radios = new JRadioButton[radioItems.length];
	
	public RadioTest() {
		setTitle("라디오 버튼의 ItemEvent 연습");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JLabel lbl = new JLabel("♬ 맛있는 후식을 선택하세요.♬");
		Font font = new Font("맑은 고딕", Font.BOLD, 15);
		lbl.setFont(font);
		ta = new JTextArea();
		
		ButtonGroup group = new ButtonGroup();
		JPanel pan = new JPanel();
		
		for (int i = 0; i < radioItems.length; i++) {
			radios[i] = new JRadioButton(radioItems[i]);
			radios[i].addItemListener(this);
			group.add(radios[i]);
			pan.add(radios[i]);
		}
		
		add(lbl, "North");
		add(ta, "Center");
		add(pan, "South");
		
		setBounds(900, 200, 400, 300);
		setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		JRadioButton eRadio = (JRadioButton) e.getSource();
		
		ta.setText(eRadio.getText() + " 후식을 선택하셨습니다.");

	}

	public static void main(String[] args) {
		new RadioTest();
	}

}
