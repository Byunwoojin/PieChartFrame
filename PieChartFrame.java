import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PieChartFrame extends JFrame{
	JTextField tf1,tf2,tf3,tf4; // 과일 판매량 입력을 위한 텍스트 필드
	int val1=0,val2=0,val3=0,val4=0; // 개별 과일 판매량
	int per1,per2,per3,per4; // 백분율
	int ang1,ang2,ang3,ang4; // 각도
	int sum=0; // 전체 판매량
	public PieChartFrame() {
		setTitle("파이 차트 그리기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout(10,10));
		MyActionListener al = new MyActionListener();
		
		JPanel panelTop = new JPanel();
		panelTop.setLayout(new FlowLayout());
		panelTop.add(new JLabel("apple"));
		panelTop.add(tf1 = new JTextField("",5)); // apple의 판매량 입력을 위한 텍스트 필드
		panelTop.add(new JLabel("cherry"));
		panelTop.add(tf2 = new JTextField("",5)); // cherry의 판매량 입력을 위한 텍스트 필드
		panelTop.add(new JLabel("strawberry"));
		panelTop.add(tf3 = new JTextField("",5)); // strawberry의 판매량 입력을 위한 텍스트 필드
		panelTop.add(new JLabel("prune"));
		panelTop.add(tf4 = new JTextField("",5)); // prune의 판매량 입력을 위한 텍스트 필드
		panelTop.setBackground(Color.lightGray);
		tf1.addActionListener(al); // 텍스트 필드에 Action이벤트 리스너 등록
		tf2.addActionListener(al);
		tf3.addActionListener(al);
		tf4.addActionListener(al);
		
		c.add(panelTop,BorderLayout.NORTH);
		c.add(new MyPanel(),BorderLayout.CENTER);
		setSize(600,400);
		setVisible(true);
	}
	class MyActionListener implements ActionListener{ 

		@Override
		public void actionPerformed(ActionEvent e) { 
			if(e.getSource()==tf1)
				val1 = Integer.parseInt(tf1.getText());
			if(e.getSource()==tf2)
				val2 = Integer.parseInt(tf2.getText());
			if(e.getSource()==tf3)
				val3 = Integer.parseInt(tf3.getText());
			if(e.getSource()==tf4)
				val4 = Integer.parseInt(tf4.getText());
			
			double sum = val1+val2+val3+val4; // 전체 판매량 계산
	
			
			//각도 계산
			ang1 = (int)Math.round(val1/sum*360.0);
			ang2 = (int)Math.round(val2/sum*360.0);
			ang3 = (int)Math.round(val3/sum*360.0);
			ang4 = (int)Math.round(val4/sum*360.0);
			// 백분율 계산
			per1 = (int)Math.round(ang1*100.0/360.0);
			per2 = (int)Math.round(ang2*100.0/360.0);
			per3 = (int)Math.round(ang3*100.0/360.0);
			per4 = (int)Math.round(ang4*100.0/360.0);
			repaint(); // 다시 그리기 지시
		}
		
	}
	class MyPanel extends JPanel{

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			int start=360; // 원호의 시작각도
			g.setFont(new Font("Arial",Font.BOLD,11)); // Font설정
			g.setColor(Color.orange); // 색상 설정
			g.drawString("prune "+per4+"%", 410, 10);  // 백분율을 나타낸 문자열 출력
			g.fillArc(190, 70, 200, 200, 0, -1*ang4); // 파이 차트 출력
			start-=ang4; 
			
			g.setColor(Color.magenta);
			g.drawString("strawberry "+per3+"%", 280, 10);
			g.fillArc(190, 70, 200, 200, start, -1*ang3);
			start-=ang3;
			
			g.setColor(Color.blue);
			g.drawString("cherry "+per2+"%", 180, 10);
			g.fillArc(190, 70, 200, 200, start, -1*ang2);
			start-=ang2;
			
			g.setColor(Color.red);
			g.drawString("apple "+per1+"%", 90, 10);
			g.fillArc(190, 70, 200, 200, start, -1*ang1);
			start-=ang1;
			
		}
		
	}
	public static void main(String[] args) {
		new PieChartFrame();
		
	}

}
