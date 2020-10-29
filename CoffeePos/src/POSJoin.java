
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class POSJoin extends JFrame {
	private ImageIcon icon;
	private int check = 0;
	String numberData;
	
	public POSJoin() {
		super("관리자 회원가입");
		setLocation(100, 100);
		
		icon = new ImageIcon("image/posback.png");
		icon = imageSetSize(icon, 380, 400);
		Container bg = getContentPane();

		

		
		// 배경 판넬 
		JPanel background = new JPanel(new BorderLayout()) {
			
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(),0,0,null);
				setOpaque(false);
				super.paintComponent(g);
			}
	};
		// 이름
		JPanel namePanel = new JPanel();
		namePanel.setBounds(10, 66, 65, 22);
		getContentPane().add(namePanel);

		JLabel nameLabel = new JLabel("이름 : ");
		nameLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		namePanel.add(nameLabel);

		JPanel nameTfPanel = new JPanel();
		nameTfPanel.setBounds(116, 60, 194, 31);
		getContentPane().add(nameTfPanel);
		//이름 TextFied
		JTextField nameTf = new JTextField(15);
		nameTfPanel.add(nameTf);
		
		// 주민등록번호
		JPanel rNumberPanel = new JPanel();
		rNumberPanel.setBounds(19, 101, 96, 22);
		getContentPane().add(rNumberPanel);

		JLabel rNumberLabel = new JLabel("주민등록번호 : ");
		rNumberLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		rNumberPanel.add(rNumberLabel);
		
		// 성별
		JPanel genderPanel = new JPanel();
		genderPanel.setBounds(15, 136, 55, 22);
		getContentPane().add(genderPanel);

		JLabel genderLabel = new JLabel("성별 : ");
		genderLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		genderPanel.add(genderLabel);
		
		// 아이디
		JPanel idPanel = new JPanel();
		idPanel.setBounds(17, 170, 61, 22);
		getContentPane().add(idPanel);

		JLabel idLabel = new JLabel("아이디 : ");
		idLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		idPanel.add(idLabel);
		
		// 비밀번호
		JPanel pwPanel = new JPanel();
		pwPanel.setBounds(14, 202, 80, 22);
		getContentPane().add(pwPanel);

		JLabel pwLabel = new JLabel("비밀번호 : ");
		pwLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		pwPanel.add(pwLabel);
		// 전화번호
		JPanel pNunberPanel = new JPanel();
		pNunberPanel.setBounds(13, 234, 82, 22);
		getContentPane().add(pNunberPanel);
		
		JLabel pNumberLabel = new JLabel("전화번호 : ");
		pNumberLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		pNunberPanel.add(pNumberLabel);
		
		// 이메일
		JPanel eMailPanel = new JPanel();
		eMailPanel.setBounds(13, 263, 70, 22);
		getContentPane().add(eMailPanel);

		JLabel eMailLabel = new JLabel("이메일 : ");
		eMailLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		eMailPanel.add(eMailLabel);
		
		// 주민등록번호TextField
		JPanel rNumberTfPanel = new JPanel();
		rNumberTfPanel.setBounds(119, 95, 186, 31);
		getContentPane().add(rNumberTfPanel);

		JTextField rNumberTf1 = new JTextField(6);
		rNumberTfPanel.add(rNumberTf1);

		JLabel label = new JLabel("-");
		rNumberTfPanel.add(label);

		JPasswordField rNumberTf2 = new JPasswordField(7);
		rNumberTfPanel.add(rNumberTf2);
		
		// 성별 TextField
		JPanel GenderTfPanel = new JPanel();
		GenderTfPanel.setBounds(108, 132, 200, 31);
		getContentPane().add(GenderTfPanel);

		JTextField genderTf = new JTextField(14);
		GenderTfPanel.add(genderTf);
		
		// IDTextField
		JPanel idTfPanel = new JPanel();
		idTfPanel.setBounds(121, 165, 162, 31);
		getContentPane().add(idTfPanel);

		JTextField idTf = new JTextField(13);
		idTfPanel.add(idTf);
		
		//PWTextField
		JPanel pwTfPanel = new JPanel();
		pwTfPanel.setBounds(106, 197, 202, 31);
		getContentPane().add(pwTfPanel);

		JTextField pwTf = new JTextField(14);
		pwTfPanel.add(pwTf);
		
		// 전화번호TextField
		JPanel pNumberTfPanel = new JPanel();
		pNumberTfPanel.setBounds(106, 229, 202, 31);
		getContentPane().add(pNumberTfPanel);

		JTextField pNumberTf = new JTextField(14);
		pNumberTfPanel.add(pNumberTf);
		
		// 이메일TextField
		JPanel eMailTfPanel = new JPanel();
		eMailTfPanel.setBounds(106, 261, 203, 31);
		getContentPane().add(eMailTfPanel);

		JTextField eMailTf = new JTextField(14);
		eMailTfPanel.add(eMailTf);
		
		// 중복확인버튼
		JPanel dCheckButtPanel = new JPanel();
		dCheckButtPanel.setBounds(289, 162, 91, 31);
		getContentPane().add(dCheckButtPanel);

		JButton dCheckButton = new JButton("중복확인");
		dCheckButton.setFont(new Font("나눔고딕", Font.BOLD, 12));
		dCheckButtPanel.add(dCheckButton);
		
		// 확인버튼
		JPanel confirmPanel = new JPanel();
		confirmPanel.setBounds(73, 332, 70, 33);
		getContentPane().add(confirmPanel);

		JButton conFirmButton = new JButton("확인");
		confirmPanel.add(conFirmButton);
		conFirmButton.setFont(new Font("나눔고딕", Font.BOLD, 12));
		
		// 취소버튼
		JPanel cancelPanel = new JPanel();
		cancelPanel.setBounds(161, 332, 70, 33);
		getContentPane().add(cancelPanel);

		JButton cancelButton = new JButton("취소");
		cancelButton.setFont(new Font("나눔고딕", Font.BOLD, 12));
		cancelPanel.add(cancelButton);
		// 닫기버튼
		JPanel closePanel = new JPanel();
		closePanel.setBounds(247, 332, 70, 33);
		getContentPane().add(closePanel);

		JButton closeButton = new JButton("닫기\r\n");
		closeButton.setFont(new Font("나눔고딕", Font.BOLD, 12));
		closePanel.add(closeButton);

		add(background);
		
		setBounds(600, 700, 400, 450);

		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);

		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new POSLogin();
				dispose();

			}
		});

		closeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});

		dCheckButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JoinDAO dao = new JoinDAO();
				
				String DCheck = idTf.getText().toString();
				
				boolean iddc = dao.dcheck(DCheck);
				
				if (iddc) {
					JOptionPane.showMessageDialog(background, "해당 아이디는 사용 중 입니다.");
				}else {
					JOptionPane.showMessageDialog(background, "해당 아이디는 사용이 가능합니다.");
				}
				check = 1;	
			}
		});
		

		conFirmButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(check == 0) {
					JOptionPane.showMessageDialog(background, "아이디 중복 확인을 해주세요.");
				}else {
					JoinDAO dao = new JoinDAO();
					
					String nameData = nameTf.getText().toString();
					String rNumberData = rNumberTf1.getText().toString() + "-" +rNumberTf2.getText().toString();
					String genderData = genderTf.getText().toString();
					String idData = idTf.getText().toString();
					String pwData = pwTf.getText().toString();
					String numberData = pNumberTf.getText().toString();
					String eMailData = eMailTf.getText().toString();
					
					int result = dao.mJoin(nameData, rNumberData, genderData, idData
							, pwData, numberData, eMailData);
					
					if(result > 0) {
						JOptionPane.showMessageDialog(background, "가입이 완료되었습니다.");
						dispose();
						new POSLogin();
					}else {
						JOptionPane.showMessageDialog(background, "아이디 중복 확인을 해주세요.");
						;
					}	
					check = 1;
				}
				
			}
		});
		
	}

	private ImageIcon imageSetSize(ImageIcon icon2, int i, int j) {
		Image ximg = icon.getImage();
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg);
		return xyimg;
	}
	
	public static void main(String[] args) {

		new POSJoin();
	}
}
