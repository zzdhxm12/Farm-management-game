package ����;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import java.awt.event.*;
import java.util.*;
import java.util.Timer;

public class Farm extends JFrame {
	private JPanel contentPane;
	public int win=0; //���׽�Ʈ ��� Ƚ��
	public int DebtDay=0; //7��(������)���� ���� �����ϱ� ���� ����ϴ� ����
	public JLabel lbl_Animal1_Property; //������ ���� ��� ��
	public JButton[] btn_CO; //���׽�Ʈ-���� ���� ��ư
	private JTextField tf_ID; //�г��� �Է� �ؽ�Ʈ �ʵ�
	private JButton btn_GameExplain; //���� ���� ��ư
	private JButton btn_CloseExplain; //���� ���� ���� ��ư
	public String ID; //�� �г���
	public int MyLV=20; //�� ����
	public int MyDebt=100000000; //�� ��
	public int MyMoney=10000; //�� ��
	public int MyExp=0; //�� ����ġ
	public int check=-1; 
	public int check2=-1;
	private JTextField tf_ID2; //�������� �г��� ���� �� ���
	public JLabel lbl_Debt; //���� �гο��� �� �� ��� ��
	public JLabel lbl_Money; //���� �гο��� �� �� ��� ���
	public AnimalAddButton btn_A1, btn_A2, btn_A3, btn_A4, btn_A5; //����_���� ��ư
	private JLabel lbl_Money_store; //����_�� �� ��� ��
	public int MyAnimalCount=0; //�� ���� ��
	public JLabel lbl_MyMoney; //�� �� ��� ��
	public JLabel lbl_MyDebt; //�� �� ��� ��
	public JLabel lbl_EXP; //�� ����ġ ��� ��
	public JButton btn_F1, btn_F2, btn_F3; //����_���/��Ÿ ��ư
	public JLabel lbl_Money_bank; //�� �� ���-����
	private JTextField tf_num1, tf_num2, tf_num3, tf_num4, tf_num5, tf_num6; //�ζ� 6�ڸ� �ؽ�Ʈ �ʵ�
	public JLabel lbl_EndingTitle; //�����гο��� Ÿ��Ʋ
	public JTextArea ta_Eding; //���� �гο��� ���� ���
	public JButton btn_EC1, btn_EC2, btn_EC3, btn_EC4, btn_EC5; //���� ������ ��ư
	public JLabel lbl_et1, lbl_et2, lbl_et3, lbl_et4, lbl_et5, lbl_et6; //���� ������ �г�-���� �̸� ��
	public Timer timer1, timer2, timer3, timer4, timer5; //�λ깰 �߰� Ÿ�̸�
	public JLabel lbl_megg, lbl_mdegg,lbl_mwool,lbl_mmeet,lbl_mmilk; //�λ깰 ���� ��� ��
	public JButton[] btn_MA=new JButton[10]; 
	public Animal[] Animal = new Animal[10];
	{
		for(int i=0;i<10;i++)
			Animal[i]=new Animal();
	}
	public int count=0;//���� ī��Ʈ
	public Item Item=new Item();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Farm frame = new Farm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Farm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 875, 597);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new CardLayout());
		setContentPane(contentPane);
		setTitle("���� ����");
		
		//���� �г�
		MyJPanel main_panel = new MyJPanel(); 
		//JPanel main_panel = new JPanel();
		main_panel.setBackground(SystemColor.info);
		contentPane.add("0", main_panel);
		main_panel.setLayout(null);
		
		//����� ���� �г�
		MyJPanel user_panel = new MyJPanel();
		//JPanel user_panel = new JPanel();
		user_panel.setBackground(SystemColor.info);
		contentPane.add("1", user_panel);
		user_panel.setLayout(null);
		
		//���� ������ �г�
		MyJPanel endingcollec_panel = new MyJPanel();
		//JPanel endingcollec_panel = new JPanel();
		endingcollec_panel.setBackground(SystemColor.info);
		contentPane.add("2", endingcollec_panel);
		endingcollec_panel.setLayout(null);
		
		//�ó����� �г�
		JPanel scenario_panel = new JPanel();
		scenario_panel.setBackground(Color.BLACK);
		contentPane.add("3", scenario_panel);
		scenario_panel.setLayout(null);
		
		//���� ���� �г�
		JPanel GameExplain_panel = new JPanel();
		GameExplain_panel.setBackground(new Color(156, 207, 200));
		GameExplain_panel.setBounds(157, 65, 490, 433);
		GameExplain_panel.setLayout(null);
		GameExplain_panel.setBorder(new LineBorder(Color.BLACK));
		GameExplain_panel.setVisible(false);
		main_panel.add(GameExplain_panel);
		
		//���� �г�
		JPanel setting_panel = new JPanel();
		setting_panel.setBackground(new Color(156, 207, 200));
		setting_panel.setBounds(231, 191, 396, 140);
		setting_panel.setLayout(null);
		setting_panel.setVisible(false);
		setting_panel.setBorder(new LineBorder(Color.BLACK));
		user_panel.add(setting_panel);
		
		//���� �гο��� ����ϴ� �г�
		JPanel set_panel = new JPanel();
		set_panel.setBackground(new Color(255, 255, 255));
		set_panel.setBounds(10, 63, 376, 60);
		set_panel.setLayout(null);
		setting_panel.add(set_panel);
						
		//���� �г�
		MyJPanel choice_panel = new MyJPanel();
		//JPanel choice_panel = new JPanel();
		choice_panel.setBackground(SystemColor.info);
		contentPane.add("4", choice_panel);
		choice_panel.setLayout(null);
		
		//���� �г�
		JPanel ending_panel = new JPanel();
		ending_panel.setBackground(Color.BLACK);
		contentPane.add("5", ending_panel);
		ending_panel.setLayout(null);
		
		//���� �г�
		JPanel game_panel = new JPanel();
		game_panel.setBackground(SystemColor.info);
		contentPane.add("6", game_panel);
		game_panel.setLayout(null);
		
		//���� ����� ���� ǥ�� �г�
		JPanel Mydata_panel = new JPanel();
		Mydata_panel.setBounds(0, 0, 847, 54);
		Mydata_panel.setBackground(new Color(156, 207, 200));
		Mydata_panel.setLayout(null);
		game_panel.add(Mydata_panel);
		
		//���� ���� ���� ȭ�� �г�
		MyJPanel2 mainview_panel = new MyJPanel2();
		//JPanel mainview_panel = new JPanel();
		mainview_panel.setBackground(SystemColor.info);
		mainview_panel.setBounds(0, 54, 847, 486);
		mainview_panel.setLayout(null);
		game_panel.add(mainview_panel);
		
		//���� �ٽú��� �г�
		JPanel reending_panel = new JPanel();
		reending_panel.setBackground(Color.BLACK);
		contentPane.add("7", reending_panel);
		reending_panel.setLayout(null);
		
		//���� �г�
		JPanel bank_panel = new JPanel();
		bank_panel.setBackground(SystemColor.info);
		contentPane.add("8", bank_panel);
		bank_panel.setLayout(null);
		
		//���� �г�
		JPanel store_panel = new JPanel();
		store_panel.setBackground(SystemColor.info);
		contentPane.add("9", store_panel);
		store_panel.setLayout(null);
		
		//����
		JTabbedPane tab_store = new JTabbedPane(JTabbedPane.TOP);
		tab_store.setBounds(14, 97, 819, 431);
		store_panel.add(tab_store);
		
		//����-����
		JPanel Panel_a = new JPanel();
		Panel_a.setBackground(new Color(156, 207, 200));
		tab_store.addTab("����", Panel_a);
		Panel_a.setLayout(null);
		
		//����-���
		JPanel Panel_f = new JPanel();
		tab_store.addTab("���/��Ÿ", Panel_f);
		Panel_f.setBackground(new Color(156, 207, 200));
		Panel_f.setLayout(null);
		
		//����-�ζ�
		JPanel Panel_l = new JPanel();
		tab_store.addTab("�ζ�", Panel_l);
		Panel_l.setBackground(new Color(156, 207, 200));
		Panel_l.setLayout(null);
		
		//���� �г�
		JPanel make_panel = new JPanel();
		make_panel.setBackground(SystemColor.info);
		contentPane.add("10", make_panel);
		make_panel.setLayout(null);
		
		//�� ���� �г�
		MyJPanel2 animal_panel = new MyJPanel2();
		animal_panel.setBackground(SystemColor.info);
		contentPane.add("10", animal_panel);
		animal_panel.setLayout(null);
		
		//���� �г�
		JPanel Help_panel = new JPanel();
		Help_panel.setBackground(SystemColor.info);
		contentPane.add("11", Help_panel);
		Help_panel.setLayout(null);
		
		//�� ������ �г�
		JPanel item_panel = new JPanel();
		item_panel.setBackground(SystemColor.info);
		contentPane.add("12", item_panel);
		item_panel.setLayout(null);
		
		//���׽�Ʈ �г�
		MyJPanel2 contest_panel = new MyJPanel2();
		contest_panel.setBackground(SystemColor.info);
		contentPane.add("13", contest_panel);
		contest_panel.setLayout(null);
		
		//���׽�Ʈ ��� �г�
		JPanel cresult_panel = new JPanel();
		cresult_panel.setBackground(SystemColor.info);
		contentPane.add("14",cresult_panel);
		cresult_panel.setLayout(null);
		
		//�� �������� ���� Ŭ���ϸ� ������ �г�
		JPanel Animal_panel = new JPanel();
		Animal_panel.setBackground(SystemColor.info);
		contentPane.add("15",Animal_panel);
		Animal_panel.setLayout(null);
		
		//���׽�Ʈ ��� ���
		JButton btn_rok = new JButton("\uD655\uC778");
		btn_rok.setBackground(Color.WHITE);
		btn_rok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				getContentPane().add(game_panel);
				game_panel.updateUI();
			}
		});
		btn_rok.setBounds(349, 382, 121, 73);
		cresult_panel.add(btn_rok);
		
		JLabel lbl_cf = new JLabel("1\uB4F1");
		lbl_cf.setFont(new Font("����", Font.BOLD, 20));
		lbl_cf.setBounds(386, 74, 58, 41);
		cresult_panel.add(lbl_cf);
		
		JLabel lbl_cs = new JLabel("2\uB4F1");
		lbl_cs.setFont(new Font("����", Font.BOLD, 20));
		lbl_cs.setBounds(146, 138, 58, 41);
		cresult_panel.add(lbl_cs);
		
		JLabel lbl_ct = new JLabel("3\uB4F1");
		lbl_ct.setFont(new Font("����", Font.BOLD, 20));
		lbl_ct.setBounds(651, 203, 58, 41);
		cresult_panel.add(lbl_ct);
		
		JLabel lbl_cf_name = new JLabel("");
		lbl_cf_name.setFont(new Font("����", Font.BOLD, 15));
		lbl_cf_name.setBounds(359, 244, 111, 38);
		cresult_panel.add(lbl_cf_name);
		
		JLabel lbl_cs_name = new JLabel("");
		lbl_cs_name.setBounds(119, 354, 111, 38);
		cresult_panel.add(lbl_cs_name);
		
		JLabel lbl_ct_name = new JLabel("");
		lbl_ct_name.setBounds(621, 382, 111, 38);
		cresult_panel.add(lbl_ct_name);
		
		JLabel lbl_cs_image = new JLabel("");
		lbl_cs_image.setBounds(108, 188, 111, 106);
		cresult_panel.add(lbl_cs_image);
		
		JLabel lbl_cf_image = new JLabel("");
		lbl_cf_image.setBounds(359, 116, 111, 106);
		cresult_panel.add(lbl_cf_image);
		
		JLabel lbl_ct_image = new JLabel("");
		lbl_ct_image.setBounds(621, 260, 111, 106);
		cresult_panel.add(lbl_ct_image);
		
		ImageIcon c2=new ImageIcon("Image/2��.png");
		ImageIcon c1=new ImageIcon("Image/1��.png");
		ImageIcon c3=new ImageIcon("Image/3��.png");
		
		JLabel lbl_crown2 = new JLabel("");
		lbl_crown2.setIcon(c2);
		lbl_crown2.setBounds(119, 63, 100, 66);
		cresult_panel.add(lbl_crown2);
		
		JLabel lbl_crown1 = new JLabel("");
		lbl_crown1.setIcon(c1);
		lbl_crown1.setBounds(359, 10, 100, 66);
		cresult_panel.add(lbl_crown1);
		
		JLabel lbl_crown3 = new JLabel("");
		lbl_crown3.setIcon(c3);
		lbl_crown3.setBounds(621, 138, 94, 67);
		cresult_panel.add(lbl_crown3);

		//���׽�Ʈ �г�
		JButton btn_bak17 = new JButton(new ImageIcon("Image/back.png"));
		btn_bak17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				getContentPane().add(game_panel);
				game_panel.updateUI();
			}
		});
		btn_bak17.setBounds(12, 10, 62, 57);
		ImageButton(btn_bak17);
		contest_panel.add(btn_bak17);
		
		btn_CO=new JButton[10];
		for(int i=0;i<10;i++)
			btn_CO[i]=new JButton("");
		btn_CO[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Animal[0].a_name==null)
				{
					JOptionPane.showMessageDialog(null, "���� ����X!", "���� ����", JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					int return_num11=JOptionPane.showConfirmDialog(null, Animal[0].a_name+"��(��) ���׽�Ʈ�� ������Ű�ðڽ��ϱ�?(������ 50000��)", "Ȯ��", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(return_num11==0)
					{
						if(MyMoney<50000)
						{
							JOptionPane.showMessageDialog(null, "������ �����մϴ�!", "�� ����", JOptionPane.WARNING_MESSAGE);
						}
						else
						{
						MyMoney-=50000;
						MyExp+=100;
						lbl_EXP.setText("Exp:"+MyExp);
						if(Animal[0].a_avility>=60&&Animal[0].a_avility<70)
						{
							MyMoney+=500000;
							MyExp+=300;
							lbl_Money.setText("��:"+MyMoney);
							lbl_EXP.setText("Exp:"+MyExp);
							lbl_ct_name.setText(Animal[0].a_name);
							lbl_ct_image.setIcon(Animal[0].a_image);
							Contest_Result_ct(lbl_cs_name,lbl_cf_name,lbl_cs_image,lbl_cf_image);
						}
						else if(Animal[0].a_avility>=70&&Animal[0].a_avility<80)
						{
							MyMoney+=1000000;
							MyExp+=500;
							lbl_Money.setText("��:"+MyMoney);
							lbl_EXP.setText("Exp:"+MyExp);
							lbl_cs_name.setText(Animal[0].a_name);
							lbl_cs_image.setIcon(Animal[0].a_image);
							Contest_Result_cs(lbl_ct_name,lbl_cf_name,lbl_ct_image,lbl_cf_image);
						}
						else if(Animal[0].a_avility>=80)
						{
							MyMoney+=2000000;
							MyExp+=1000;
							lbl_Money.setText("��:"+MyMoney);
							lbl_EXP.setText("Exp:"+MyExp);
							lbl_cf_name.setText(Animal[0].a_name);
							lbl_cf_image.setIcon(Animal[0].a_image);
							Contest_Result_cf(lbl_cs_name,lbl_ct_name,lbl_cs_image,lbl_ct_image);
							}
							else
							{
							Contest_Result_no(lbl_cs_name,lbl_cf_name,lbl_ct_name,
									lbl_cs_image,lbl_cf_image,lbl_ct_image);
							}
							getContentPane().removeAll();
							getContentPane().add(cresult_panel);
							cresult_panel.updateUI();
						}
					}
				}
			}
			});
		btn_CO[0].setBounds(27, 120, 130, 183);
		contest_panel.add(btn_CO[0]);
		
		btn_CO[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Animal[1].a_name==null)
				{
					JOptionPane.showMessageDialog(null, "���� ����X!", "���� ����", JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					int return_num11=JOptionPane.showConfirmDialog(null, Animal[1].a_name+"��(��) ���׽�Ʈ�� ������Ű�ðڽ��ϱ�?(������ 50000��)", "Ȯ��", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(return_num11==0)
					{
						if(MyMoney<50000)
						{
							JOptionPane.showMessageDialog(null, "������ �����մϴ�!", "�� ����", JOptionPane.WARNING_MESSAGE);
						}
						else
						{
						MyMoney-=50000;
						MyExp+=100;
						lbl_EXP.setText("Exp:"+MyExp);
						if(Animal[1].a_avility>=60&&Animal[1].a_avility<70)
						{
							MyMoney+=500000;
							MyExp+=300;
							lbl_Money.setText("��:"+MyMoney);
							lbl_EXP.setText("Exp:"+MyExp);
							lbl_ct_name.setText(Animal[1].a_name);
							lbl_ct_image.setIcon(Animal[1].a_image);
							Contest_Result_ct(lbl_cs_name,lbl_cf_name,lbl_cs_image,lbl_cf_image);
						}
						else if(Animal[1].a_avility>=70&&Animal[1].a_avility<80)
						{
							MyMoney+=1000000;
							MyExp+=500;
							lbl_Money.setText("��:"+MyMoney);
							lbl_EXP.setText("Exp:"+MyExp);
							lbl_cs_name.setText(Animal[1].a_name);
							lbl_cs_image.setIcon(Animal[1].a_image);
							Contest_Result_cs(lbl_ct_name,lbl_cf_name,lbl_ct_image,lbl_cf_image);
						}
						else if(Animal[1].a_avility>=80)
						{
							MyMoney+=2000000;
							MyExp+=1000;
							lbl_Money.setText("��:"+MyMoney);
							lbl_EXP.setText("Exp:"+MyExp);
							lbl_cf_name.setText(Animal[1].a_name);
							lbl_cf_image.setIcon(Animal[1].a_image);
							Contest_Result_cf(lbl_cs_name,lbl_ct_name,lbl_cs_image,lbl_ct_image);
						}
						else
						{
							Contest_Result_no(lbl_cs_name,lbl_cf_name,lbl_ct_name,
									lbl_cs_image,lbl_cf_image,lbl_ct_image);
						}
						getContentPane().removeAll();
						getContentPane().add(cresult_panel);
						cresult_panel.updateUI();
						}
					}
				}
			}
			});
		btn_CO[1].setBounds(186, 120, 130, 183);
		contest_panel.add(btn_CO[1]);
		
		btn_CO[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Animal[2].a_name==null)
				{
					JOptionPane.showMessageDialog(null, "���� ����X!", "���� ����", JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					if(MyMoney<50000)
					{
						JOptionPane.showMessageDialog(null, "������ �����մϴ�!", "�� ����", JOptionPane.WARNING_MESSAGE);
					}
					else
					{
					MyMoney-=50000;
					MyExp+=100;
					lbl_EXP.setText("Exp:"+MyExp);
					int return_num11=JOptionPane.showConfirmDialog(null, Animal[2].a_name+"��(��) ���׽�Ʈ�� ������Ű�ðڽ��ϱ�?(������ 50000��)", "Ȯ��", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(return_num11==0)
					{
						if(Animal[2].a_avility>=60&&Animal[2].a_avility<70)
						{
							MyMoney+=500000;
							MyExp+=300;
							lbl_Money.setText("��:"+MyMoney);
							lbl_EXP.setText("Exp:"+MyExp);
							lbl_ct_name.setText(Animal[2].a_name);
							lbl_ct_image.setIcon(Animal[2].a_image);
							Contest_Result_ct(lbl_cs_name,lbl_cf_name,lbl_cs_image,lbl_cf_image);
						}
						else if(Animal[2].a_avility>=70&&Animal[2].a_avility<80)
						{
							MyMoney+=1000000;
							MyExp+=500;
							lbl_Money.setText("��:"+MyMoney);
							lbl_EXP.setText("Exp:"+MyExp);
							lbl_cs_name.setText(Animal[2].a_name);
							lbl_cs_image.setIcon(Animal[2].a_image);
							Contest_Result_cs(lbl_ct_name,lbl_cf_name,lbl_ct_image,lbl_cf_image);
						}
						else if(Animal[2].a_avility>=80)
						{
							MyMoney+=2000000;
							MyExp+=1000;
							lbl_Money.setText("��:"+MyMoney);
							lbl_EXP.setText("Exp:"+MyExp);
							lbl_cf_name.setText(Animal[2].a_name);
							lbl_cf_image.setIcon(Animal[2].a_image);
							Contest_Result_cf(lbl_cs_name,lbl_ct_name,lbl_cs_image,lbl_ct_image);
						}
						else
						{
							Contest_Result_no(lbl_cs_name,lbl_cf_name,lbl_ct_name,
									lbl_cs_image,lbl_cf_image,lbl_ct_image);
						}
						getContentPane().removeAll();
						getContentPane().add(cresult_panel);
						cresult_panel.updateUI();
					}
					}
				}
			}
			});
		btn_CO[2].setBounds(352, 120, 130, 183);
		contest_panel.add(btn_CO[2]);
		
		btn_CO[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Animal[3].a_name==null)
				{
					JOptionPane.showMessageDialog(null, "���� ����X!", "���� ����", JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					int return_num11=JOptionPane.showConfirmDialog(null, Animal[3].a_name+"��(��) ���׽�Ʈ�� ������Ű�ðڽ��ϱ�?(������ 50000��)", "Ȯ��", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(return_num11==0)
					{
						if(MyMoney<50000)
						{
							JOptionPane.showMessageDialog(null, "������ �����մϴ�!", "�� ����", JOptionPane.WARNING_MESSAGE);
						}
						else
						{
						MyMoney-=50000;
						MyExp+=100;
						lbl_EXP.setText("Exp:"+MyExp);
						if(Animal[3].a_avility>=60&&Animal[3].a_avility<70)
						{
							MyMoney+=500000;
							MyExp+=300;
							lbl_Money.setText("��:"+MyMoney);
							lbl_EXP.setText("Exp:"+MyExp);
							lbl_ct_name.setText(Animal[3].a_name);
							lbl_ct_image.setIcon(Animal[3].a_image);
							Contest_Result_ct(lbl_cs_name,lbl_cf_name,lbl_cs_image,lbl_cf_image);
						}
						else if(Animal[3].a_avility>=70&&Animal[3].a_avility<80)
						{
							MyMoney+=1000000;
							MyExp+=500;
							lbl_Money.setText("��:"+MyMoney);
							lbl_EXP.setText("Exp:"+MyExp);
							lbl_cs_name.setText(Animal[3].a_name);
							lbl_cs_image.setIcon(Animal[3].a_image);
							Contest_Result_cs(lbl_ct_name,lbl_cf_name,lbl_ct_image,lbl_cf_image);
						}
						else if(Animal[3].a_avility>=80)
						{
							MyMoney+=2000000;
							MyExp+=1000;
							lbl_Money.setText("��:"+MyMoney);
							lbl_EXP.setText("Exp:"+MyExp);
							lbl_cf_name.setText(Animal[3].a_name);
							lbl_cf_image.setIcon(Animal[3].a_image);
							Contest_Result_cf(lbl_cs_name,lbl_ct_name,lbl_cs_image,lbl_ct_image);
						}
						else
						{
							Contest_Result_no(lbl_cs_name,lbl_cf_name,lbl_ct_name,
									lbl_cs_image,lbl_cf_image,lbl_ct_image);
						}
						getContentPane().removeAll();
						getContentPane().add(cresult_panel);
						cresult_panel.updateUI();
					}
					}
				}
			}
			});
		btn_CO[3].setBounds(517, 120, 130, 183);
		contest_panel.add(btn_CO[3]);
		
		btn_CO[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Animal[4].a_name==null)
				{
					JOptionPane.showMessageDialog(null, "���� ����X!", "���� ����", JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					int return_num11=JOptionPane.showConfirmDialog(null, Animal[4].a_name+"��(��) ���׽�Ʈ�� ������Ű�ðڽ��ϱ�?(������ 50000��)", "Ȯ��", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(return_num11==0)
					{
						if(MyMoney<50000)
						{
							JOptionPane.showMessageDialog(null, "������ �����մϴ�!", "�� ����", JOptionPane.WARNING_MESSAGE);
						}
						else
						{
						MyMoney-=50000;
						MyExp+=100;
						lbl_EXP.setText("Exp:"+MyExp);
						if(Animal[4].a_avility>=60&&Animal[4].a_avility<70)
						{
							MyMoney+=500000;
							MyExp+=300;
							lbl_Money.setText("��:"+MyMoney);
							lbl_EXP.setText("Exp:"+MyExp);
							lbl_ct_name.setText(Animal[4].a_name);
							lbl_ct_image.setIcon(Animal[4].a_image);
							Contest_Result_ct(lbl_cs_name,lbl_cf_name,lbl_cs_image,lbl_cf_image);
						}
						else if(Animal[4].a_avility>=70&&Animal[4].a_avility<80)
						{
							MyMoney+=1000000;
							MyExp+=500;
							lbl_Money.setText("��:"+MyMoney);
							lbl_EXP.setText("Exp:"+MyExp);
							lbl_cs_name.setText(Animal[4].a_name);
							lbl_cs_image.setIcon(Animal[4].a_image);
							Contest_Result_cs(lbl_ct_name,lbl_cf_name,lbl_ct_image,lbl_cf_image);
						}
						else if(Animal[4].a_avility>=80)
						{
							MyMoney+=2000000;
							MyExp+=1000;
							lbl_Money.setText("��:"+MyMoney);
							lbl_EXP.setText("Exp:"+MyExp);
							lbl_cf_name.setText(Animal[4].a_name);
							lbl_cf_image.setIcon(Animal[4].a_image);
							Contest_Result_cf(lbl_cs_name,lbl_ct_name,lbl_cs_image,lbl_ct_image);
						}
						else
						{
							Contest_Result_no(lbl_cs_name,lbl_cf_name,lbl_ct_name,
									lbl_cs_image,lbl_cf_image,lbl_ct_image);
						}
						getContentPane().removeAll();
						getContentPane().add(cresult_panel);
						cresult_panel.updateUI();
					}
					}
				}
			}
			});
		btn_CO[4].setBounds(687, 120, 130, 183);
		contest_panel.add(btn_CO[4]);
		
		btn_CO[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Animal[5].a_name==null)
				{
					JOptionPane.showMessageDialog(null, "���� ����X!", "���� ����", JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					int return_num11=JOptionPane.showConfirmDialog(null, Animal[5].a_name+"��(��) ���׽�Ʈ�� ������Ű�ðڽ��ϱ�?(������ 50000��)", "Ȯ��", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(return_num11==0)
					{
						if(MyMoney<50000)
						{
							JOptionPane.showMessageDialog(null, "������ �����մϴ�!", "�� ����", JOptionPane.WARNING_MESSAGE);
						}
						else
						{
						MyMoney-=50000;
						MyExp+=100;
						lbl_EXP.setText("Exp:"+MyExp);
						if(Animal[5].a_avility>=60&&Animal[5].a_avility<70)
						{
							MyMoney+=500000;
							MyExp+=300;
							lbl_Money.setText("��:"+MyMoney);
							lbl_EXP.setText("Exp:"+MyExp);
							lbl_ct_name.setText(Animal[5].a_name);
							lbl_ct_image.setIcon(Animal[5].a_image);
							Contest_Result_ct(lbl_cs_name,lbl_cf_name,lbl_cs_image,lbl_cf_image);
						}
						else if(Animal[5].a_avility>=70&&Animal[5].a_avility<80)
						{
							MyMoney+=1000000;
							MyExp+=500;
							lbl_Money.setText("��:"+MyMoney);
							lbl_EXP.setText("Exp:"+MyExp);
							lbl_cs_name.setText(Animal[5].a_name);
							lbl_cs_image.setIcon(Animal[5].a_image);
							Contest_Result_cs(lbl_ct_name,lbl_cf_name,lbl_ct_image,lbl_cf_image);
						}
						else if(Animal[1].a_avility>=80)
						{
							MyMoney+=2000000;
							MyExp+=1000;
							lbl_Money.setText("��:"+MyMoney);
							lbl_EXP.setText("Exp:"+MyExp);
							lbl_cf_name.setText(Animal[5].a_name);
							lbl_cf_image.setIcon(Animal[5].a_image);
							Contest_Result_cf(lbl_cs_name,lbl_ct_name,lbl_cs_image,lbl_ct_image);
						}
						else
						{
							Contest_Result_no(lbl_cs_name,lbl_cf_name,lbl_ct_name,
									lbl_cs_image,lbl_cf_image,lbl_ct_image);
						}
						getContentPane().removeAll();
						getContentPane().add(cresult_panel);
						cresult_panel.updateUI();
					}
					}
				}
			}
			});
		btn_CO[5].setBounds(27, 333, 130, 183);
		contest_panel.add(btn_CO[5]);
		
		btn_CO[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Animal[6].a_name==null)
				{
					JOptionPane.showMessageDialog(null, "���� ����X!", "���� ����", JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					int return_num11=JOptionPane.showConfirmDialog(null, Animal[6].a_name+"��(��) ���׽�Ʈ�� ������Ű�ðڽ��ϱ�?(������ 50000��)", "Ȯ��", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(return_num11==0)
					{
						if(MyMoney<50000)
						{
							JOptionPane.showMessageDialog(null, "������ �����մϴ�!", "�� ����", JOptionPane.WARNING_MESSAGE);
						}
						else
						{
						MyMoney-=50000;
						MyExp+=100;
						lbl_EXP.setText("Exp:"+MyExp);
						if(Animal[6].a_avility>=60&&Animal[6].a_avility<70)
						{
							MyMoney+=500000;
							MyExp+=300;
							lbl_Money.setText("��:"+MyMoney);
							lbl_EXP.setText("Exp:"+MyExp);
							lbl_ct_name.setText(Animal[6].a_name);
							lbl_ct_image.setIcon(Animal[6].a_image);
							Contest_Result_ct(lbl_cs_name,lbl_cf_name,lbl_cs_image,lbl_cf_image);
						}
						else if(Animal[6].a_avility>=70&&Animal[6].a_avility<80)
						{
							MyMoney+=1000000;
							MyExp+=500;
							lbl_Money.setText("��:"+MyMoney);
							lbl_EXP.setText("Exp:"+MyExp);
							lbl_cs_name.setText(Animal[6].a_name);
							lbl_cs_image.setIcon(Animal[6].a_image);
							Contest_Result_cs(lbl_ct_name,lbl_cf_name,lbl_ct_image,lbl_cf_image);
						}
						else if(Animal[6].a_avility>=80)
						{
							MyMoney+=2000000;
							MyExp+=1000;
							lbl_Money.setText("��:"+MyMoney);
							lbl_EXP.setText("Exp:"+MyExp);
							lbl_cf_name.setText(Animal[6].a_name);
							lbl_cf_image.setIcon(Animal[6].a_image);
							Contest_Result_cf(lbl_cs_name,lbl_ct_name,lbl_cs_image,lbl_ct_image);
						}
						else
						{
							Contest_Result_no(lbl_cs_name,lbl_cf_name,lbl_ct_name,
									lbl_cs_image,lbl_cf_image,lbl_ct_image);
						}
						getContentPane().removeAll();
						getContentPane().add(cresult_panel);
						cresult_panel.updateUI();
					}
					}
				}
			}
			});
		btn_CO[6].setBounds(186, 333, 130, 183);
		contest_panel.add(btn_CO[6]);
		
		btn_CO[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Animal[7].a_name==null)
				{
					JOptionPane.showMessageDialog(null, "���� ����X!", "���� ����", JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					int return_num11=JOptionPane.showConfirmDialog(null, Animal[7].a_name+"��(��) ���׽�Ʈ�� ������Ű�ðڽ��ϱ�?(������ 50000��)", "Ȯ��", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(return_num11==0)
					{
						if(MyMoney<50000)
						{
							JOptionPane.showMessageDialog(null, "������ �����մϴ�!", "�� ����", JOptionPane.WARNING_MESSAGE);
						}
						else
						{
						MyMoney-=50000;
						MyExp+=100;
						lbl_EXP.setText("Exp:"+MyExp);
						if(Animal[7].a_avility>=60&&Animal[7].a_avility<70)
						{
							MyMoney+=500000;
							MyExp+=300;
							lbl_Money.setText("��:"+MyMoney);
							lbl_EXP.setText("Exp:"+MyExp);
							lbl_ct_name.setText(Animal[7].a_name);
							lbl_ct_image.setIcon(Animal[7].a_image);
							Contest_Result_ct(lbl_cs_name,lbl_cf_name,lbl_cs_image,lbl_cf_image);
						}
						else if(Animal[7].a_avility>=70&&Animal[7].a_avility<80)
						{
							MyMoney+=1000000;
							MyExp+=500;
							lbl_Money.setText("��:"+MyMoney);
							lbl_EXP.setText("Exp:"+MyExp);
							lbl_cs_name.setText(Animal[7].a_name);
							lbl_cs_image.setIcon(Animal[7].a_image);
							Contest_Result_cs(lbl_ct_name,lbl_cf_name,lbl_ct_image,lbl_cf_image);
						}
						else if(Animal[7].a_avility>=80)
						{
							MyMoney+=2000000;
							MyExp+=1000;
							lbl_Money.setText("��:"+MyMoney);
							lbl_EXP.setText("Exp:"+MyExp);
							lbl_cf_name.setText(Animal[7].a_name);
							lbl_cf_image.setIcon(Animal[7].a_image);
							Contest_Result_cf(lbl_cs_name,lbl_ct_name,lbl_cs_image,lbl_ct_image);
						}
						else
						{
							Contest_Result_no(lbl_cs_name,lbl_cf_name,lbl_ct_name,
									lbl_cs_image,lbl_cf_image,lbl_ct_image);
						}
						getContentPane().removeAll();
						getContentPane().add(cresult_panel);
						cresult_panel.updateUI();
					}
					}
				}
			}
			});
		btn_CO[7].setBounds(352, 333, 130, 183);
		contest_panel.add(btn_CO[7]);
		
		btn_CO[8].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Animal[8].a_name==null)
				{
					JOptionPane.showMessageDialog(null, "���� ����X!", "���� ����", JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					int return_num11=JOptionPane.showConfirmDialog(null, Animal[8].a_name+"��(��) ���׽�Ʈ�� ������Ű�ðڽ��ϱ�?(������ 50000��)", "Ȯ��", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(return_num11==0)
					{
						if(MyMoney<50000)
						{
							JOptionPane.showMessageDialog(null, "������ �����մϴ�!", "�� ����", JOptionPane.WARNING_MESSAGE);
						}
						else
						{
						MyMoney-=50000;
						MyExp+=100;
						lbl_EXP.setText("Exp:"+MyExp);
						if(Animal[8].a_avility>=60&&Animal[8].a_avility<70)
						{
							MyMoney+=500000;
							MyExp+=300;
							lbl_Money.setText("��:"+MyMoney);
							lbl_EXP.setText("Exp:"+MyExp);
							lbl_ct_name.setText(Animal[8].a_name);
							lbl_ct_image.setIcon(Animal[8].a_image);
							Contest_Result_ct(lbl_cs_name,lbl_cf_name,lbl_cs_image,lbl_cf_image);
						}
						else if(Animal[8].a_avility>=70&&Animal[8].a_avility<80)
						{
							MyMoney+=1000000;
							MyExp+=500;
							lbl_Money.setText("��:"+MyMoney);
							lbl_EXP.setText("Exp:"+MyExp);
							lbl_cs_name.setText(Animal[8].a_name);
							lbl_cs_image.setIcon(Animal[8].a_image);
							Contest_Result_cs(lbl_ct_name,lbl_cf_name,lbl_ct_image,lbl_cf_image);
						}
						else if(Animal[8].a_avility>=80)
						{
							MyMoney+=2000000;
							MyExp+=1000;
							lbl_Money.setText("��:"+MyMoney);
							lbl_EXP.setText("Exp:"+MyExp);
							lbl_cf_name.setText(Animal[8].a_name);
							lbl_cf_image.setIcon(Animal[8].a_image);
							Contest_Result_cf(lbl_cs_name,lbl_ct_name,lbl_cs_image,lbl_ct_image);
						}
						else
						{
							Contest_Result_no(lbl_cs_name,lbl_cf_name,lbl_ct_name,
									lbl_cs_image,lbl_cf_image,lbl_ct_image);
						}
						getContentPane().removeAll();
						getContentPane().add(cresult_panel);
						cresult_panel.updateUI();
					}
					}
				}
			}
			});
		btn_CO[8].setBounds(517, 333, 130, 183);
		contest_panel.add(btn_CO[8]);
		
		btn_CO[9].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Animal[9].a_name==null)
				{
					JOptionPane.showMessageDialog(null, "���� ����X!", "���� ����", JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					int return_num11=JOptionPane.showConfirmDialog(null, Animal[9].a_name+"��(��) ���׽�Ʈ�� ������Ű�ðڽ��ϱ�?(������ 50000��)", "Ȯ��", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(return_num11==0)
					{
						if(MyMoney<50000)
						{
							JOptionPane.showMessageDialog(null, "������ �����մϴ�!", "�� ����", JOptionPane.WARNING_MESSAGE);
						}
						else
						{
						MyMoney-=50000;
						MyExp+=100;
						lbl_EXP.setText("Exp:"+MyExp);
						if(Animal[9].a_avility>=60&&Animal[9].a_avility<70)
						{
							MyMoney+=500000;
							MyExp+=300;
							lbl_Money.setText("��:"+MyMoney);
							lbl_EXP.setText("Exp:"+MyExp);
							lbl_ct_name.setText(Animal[9].a_name);
							lbl_ct_image.setIcon(Animal[9].a_image);
							Contest_Result_ct(lbl_cs_name,lbl_cf_name,lbl_cs_image,lbl_cf_image);
						}
						else if(Animal[9].a_avility>=70&&Animal[9].a_avility<80)
						{
							MyMoney+=1000000;
							MyExp+=500;
							lbl_Money.setText("��:"+MyMoney);
							lbl_EXP.setText("Exp:"+MyExp);
							lbl_cs_name.setText(Animal[9].a_name);
							lbl_cs_image.setIcon(Animal[9].a_image);
							Contest_Result_cs(lbl_ct_name,lbl_cf_name,lbl_ct_image,lbl_cf_image);
						}
						else if(Animal[9].a_avility>=80)
						{
							MyMoney+=2000000;
							MyExp+=1000;
							lbl_Money.setText("��:"+MyMoney);
							lbl_EXP.setText("Exp:"+MyExp);
							lbl_cf_name.setText(Animal[9].a_name);
							lbl_cf_image.setIcon(Animal[9].a_image);
							Contest_Result_cf(lbl_cs_name,lbl_ct_name,lbl_cs_image,lbl_ct_image);
						}
						else
						{
							Contest_Result_no(lbl_cs_name,lbl_cf_name,lbl_ct_name,
									lbl_cs_image,lbl_cf_image,lbl_ct_image);
						}
						getContentPane().removeAll();
						getContentPane().add(cresult_panel);
						cresult_panel.updateUI();
					}
					}
				}
			}
			});
		btn_CO[9].setBounds(687, 333, 130, 183);
		contest_panel.add(btn_CO[9]);
		
		//�� �Ǹ�
		JButton btn_shouse = new JButton(new ImageIcon("Image/��.png"));
		ImageButton(btn_shouse);
		btn_shouse.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent arg0) {
	            int return_num11=JOptionPane.showConfirmDialog(null, "���� ���� �Ľðڽ��ϱ�?", "Ȯ��", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	            if(return_num11==0)
	            {
	               MyMoney+=30000000;

	               if(MyMoney>=MyDebt)//���� �г�
	               {
	                  getContentPane().removeAll();
	                  getContentPane().add(ending_panel);
	                  ending_panel.updateUI();
	                  Ending(lbl_EndingTitle, ta_Eding, 1);
	                  btn_EC2.setEnabled(true);
	                  btn_EC2.setIcon(new ImageIcon("Image/ending2.png"));
	                  lbl_et2.setText("2. ����� ��");
	                  for(int i=0;i<10;i++)
	                  {
	                     Animal[i].a_avility=0;
	                     Animal[i].a_hp=10;
	                     Animal[i].a_name=null;
	                     Animal[i].a_image=null;
	                     Animal[i].a_property=null;
	                     Animal[i].a_species=null;
	                     btn_MA[i].setIcon(null);
	                     btn_MA[i].setText("");
	                     btn_CO[i].setIcon(null);
	                     btn_CO[i].setText("");
	                  }
	               }
	               else 
	               {
	                  getContentPane().removeAll();
	                  getContentPane().add(ending_panel);
	                  ending_panel.updateUI();
	                  Ending(lbl_EndingTitle, ta_Eding, 0);
	                  btn_EC1.setEnabled(true);
	                  btn_EC1.setIcon(new ImageIcon("Image/ending1.png"));
	                  lbl_et1.setText("1. �Ļ�");
	                  for(int i=0;i<10;i++)
	                  {
	                     Animal[i].a_avility=0;
	                     Animal[i].a_hp=10;
	                     Animal[i].a_name=null;
	                     Animal[i].a_image=null;
	                     Animal[i].a_property=null;
	                     Animal[i].a_species=null;
	                     btn_MA[i].setIcon(null);
	                     btn_MA[i].setText("");
	                     btn_CO[i].setIcon(null);
	                     btn_CO[i].setText("");
	                  }
	               }
	               
	               MyMoney=10000;
	               MyDebt=100000000;
	               lbl_Money.setText("��:"+MyMoney);
	               lbl_Debt.setText("��:"+MyDebt);
	            }
	         }
	      });
		
		//â�� �г�
		lbl_megg = new JLabel("");
		lbl_megg.setBounds(149, 293, 32, 26);
		item_panel.add(lbl_megg);
		
		lbl_mdegg = new JLabel("");
		lbl_mdegg.setBounds(309, 293, 32, 26);
		item_panel.add(lbl_mdegg);
		
		lbl_mwool = new JLabel("");
		lbl_mwool.setBounds(470, 293, 32, 26);
		item_panel.add(lbl_mwool);
	      
		lbl_mmeet = new JLabel("");
		lbl_mmeet.setBounds(631, 293, 32, 26);
		item_panel.add(lbl_mmeet);
		
		lbl_mmilk = new JLabel("");
		lbl_mmilk.setBounds(791, 293, 32, 26);
		item_panel.add(lbl_mmilk);
		
		JLabel lbl_mcheese = new JLabel("");
		lbl_mcheese.setBounds(164, 452, 32, 26);
		item_panel.add(lbl_mcheese);
		
		JLabel lbl_myarn = new JLabel("");
		lbl_myarn.setBounds(358, 452, 32, 26);
		item_panel.add(lbl_myarn);
	      
		JLabel lbl_msausage = new JLabel("");
		lbl_msausage.setBounds(549, 452, 32, 26);
		item_panel.add(lbl_msausage);
		
		JLabel lbl_myogurt = new JLabel("");
		lbl_myogurt.setBounds(746, 452, 32, 26);
		item_panel.add(lbl_myogurt);
		
		JLabel lbl_mhfeed = new JLabel("");
		lbl_mhfeed.setBounds(358, 145, 32, 26);
		item_panel.add(lbl_mhfeed);
		
		JLabel lbl_mlfeed = new JLabel("");
		lbl_mlfeed.setBounds(549, 145, 32, 26);
		item_panel.add(lbl_mlfeed);
		
		JLabel lbl_mmedicine = new JLabel("");
		lbl_mmedicine.setBounds(746, 145, 32, 26);
		item_panel.add(lbl_mmedicine);
		btn_shouse.setBounds(59, 92, 104, 79);
		item_panel.add(btn_shouse);
		
		JButton btn_segg = new JButton(new ImageIcon("Image/�ް�.png"));
		ImageButton(btn_segg);
		btn_segg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String eggc = JOptionPane.showInputDialog("�Ǹ��Ͻ� �ް��� ������ �Է����ּ���.");
				
	            int return_num12=JOptionPane.showConfirmDialog(null, "�ް� "+eggc+"���� �Ǹ��Ͻðڽ��ϱ�?", "Ȯ��", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	            if(return_num12==0)
	            {
	               Item.egg-=Integer.parseInt(eggc);
	               lbl_megg.setText(Item.egg+"");
	               MyMoney+=Integer.parseInt(eggc)*1000;
	               MyExp+=5*Integer.parseInt(eggc);
	               lbl_EXP.setText("Exp:"+MyExp);
	               lbl_Money.setText("��:"+MyMoney);
	            }
	            else
	            {
	               JOptionPane.showMessageDialog(null, "���� ����!", "���� ����", JOptionPane.WARNING_MESSAGE);
	            }
	         }
	      });
	      btn_segg.setBounds(45, 240, 104, 79);
	      item_panel.add(btn_segg);
	      
	      JButton btn_mdegg = new JButton(new ImageIcon("Image/������.png"));
	      ImageButton(btn_mdegg);
	      btn_mdegg.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent arg0) {
	            String deggc = JOptionPane.showInputDialog("�Ǹ��Ͻ� �������� ������ �Է����ּ���.");
	            
	            int return_num13=JOptionPane.showConfirmDialog(null, "������ "+deggc+"���� �Ǹ��Ͻðڽ��ϱ�?", "Ȯ��", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	            if(return_num13==0)
	            {
	               Item.degg-=Integer.parseInt(deggc);
	               lbl_mdegg.setText(Item.degg+"");
	               MyMoney+=Integer.parseInt(deggc)*4000;
	               MyExp+=15*Integer.parseInt(deggc);
	               lbl_EXP.setText("Exp:"+MyExp);
	               lbl_Money.setText("��:"+MyMoney);
	            }
	            else
	            {
	               JOptionPane.showMessageDialog(null, "���� ����!", "���� ����", JOptionPane.WARNING_MESSAGE);
	            }
	         }
	      });
	      btn_mdegg.setBounds(204, 240, 104, 79);
	      item_panel.add(btn_mdegg);
	      
	      JButton btn_mwool = new JButton(new ImageIcon("Image/����.png"));
	      ImageButton(btn_mwool);
	      btn_mwool.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent arg0) {
	            String woolc = JOptionPane.showInputDialog("�Ǹ��Ͻ� ������ ������ �Է����ּ���.");
	            
	            int return_num14=JOptionPane.showConfirmDialog(null, "���� "+woolc+"���� �Ǹ��Ͻðڽ��ϱ�?", "Ȯ��", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	            if(return_num14==0)
	            {
	               if(Item.wool>0)
	               {
	                  Item.wool-=Integer.parseInt(woolc);
	                  lbl_mwool.setText(Item.wool+"");
	                  MyMoney+=Integer.parseInt(woolc)*5000;
	                  MyExp+=30*Integer.parseInt(woolc);
	                  lbl_EXP.setText("Exp:"+MyExp);
	                  lbl_Money.setText("��:"+MyMoney);
	               }
	               else
	               {
	                  JOptionPane.showMessageDialog(null, "���� ����!", "���� ����", JOptionPane.WARNING_MESSAGE);
	               }
	            }
	         }
	      });
	      btn_mwool.setBounds(366, 240, 104, 79);
	      item_panel.add(btn_mwool);
	      
	      JButton btn_mmeet = new JButton(new ImageIcon("Image/���.png"));
	      ImageButton(btn_mmeet);
	      btn_mmeet.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent arg0) {
	            String meetc = JOptionPane.showInputDialog("�Ǹ��Ͻ� ����� ������ �Է����ּ���.");
	            
	            int return_num15=JOptionPane.showConfirmDialog(null, "��� "+meetc+"���� �Ǹ��Ͻðڽ��ϱ�?", "Ȯ��", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	            if(return_num15==0)
	            {
	               Item.meet-=Integer.parseInt(meetc);
	               lbl_mmeet.setText(Item.meet+"");
	               MyMoney+=Integer.parseInt(meetc)*10000;
	               MyExp+=50*Integer.parseInt(meetc);
	               lbl_EXP.setText("Exp:"+MyExp);
	               lbl_Money.setText("��:"+MyMoney);
	            }
	            else
	            {
	               JOptionPane.showMessageDialog(null, "���� ����!", "���� ����", JOptionPane.WARNING_MESSAGE);
	            }
	         }
	      });
	      btn_mmeet.setBounds(528, 240, 104, 79);
	      item_panel.add(btn_mmeet);
	      
	      JButton btn_mmilk = new JButton(new ImageIcon("Image/����.png"));
	      ImageButton(btn_mmilk);
	      btn_mmilk.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent arg0) {
	            String milkc = JOptionPane.showInputDialog("�Ǹ��Ͻ� ������ ������ �Է����ּ���.");
	            
	            int return_num16=JOptionPane.showConfirmDialog(null, "���� "+milkc+"���� �Ǹ��Ͻðڽ��ϱ�?", "Ȯ��", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	            if(return_num16==0)
	            {
	               Item.milk-=Integer.parseInt(milkc);
	               lbl_mmilk.setText(Item.milk+"");
	               MyMoney+=Integer.parseInt(milkc)*30000;
	               MyExp+=100*Integer.parseInt(milkc);
	               lbl_EXP.setText("Exp:"+MyExp);
	               lbl_Money.setText("��:"+MyMoney);
	            }
	            else
	            {
	               JOptionPane.showMessageDialog(null, "���� ����!", "���� ����", JOptionPane.WARNING_MESSAGE);
	            }
	         }
	      });
	      btn_mmilk.setBounds(687, 235, 104, 84);
	      item_panel.add(btn_mmilk);
	      
	      JButton btn_myarn = new JButton(new ImageIcon("Image/��.png"));
	      ImageButton(btn_myarn);
	      btn_myarn.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent arg0) {
	            String yarnc = JOptionPane.showInputDialog("�Ǹ��Ͻ� ���� ������ �Է����ּ���.");
	            
	            int return_num18=JOptionPane.showConfirmDialog(null, "�� "+yarnc+"���� �Ǹ��Ͻðڽ��ϱ�?", "Ȯ��", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	            if(return_num18==0)
	            {
	               Item.yarn-=Integer.parseInt(yarnc);
	               lbl_myarn.setText(Item.yarn+"");
	               MyMoney+=Integer.parseInt(yarnc)*30000;
	               MyExp+=120*Integer.parseInt(yarnc);
	               lbl_EXP.setText("Exp:"+MyExp);
	               lbl_Money.setText("��:"+MyMoney);
	            }
	            else
	            {
	               JOptionPane.showMessageDialog(null, "���� ����!", "���� ����", JOptionPane.WARNING_MESSAGE);
	            }
	         }
	      });
	      btn_myarn.setBounds(253, 399, 104, 79);
	      item_panel.add(btn_myarn);
	      
	      JButton btn_myogurt = new JButton(new ImageIcon("Image/�䱸��Ʈ.png"));
	      ImageButton(btn_myogurt);
	      btn_myogurt.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent arg0) {
	            String yogurtc = JOptionPane.showInputDialog("�Ǹ��Ͻ� �䱸��Ʈ�� ������ �Է����ּ���.");
	            
	            int return_num10=JOptionPane.showConfirmDialog(null, "�䱸��Ʈ "+yogurtc+"���� �Ǹ��Ͻðڽ��ϱ�?", "Ȯ��", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	            if(return_num10==0)
	            {
	               Item.yogurt-=Integer.parseInt(yogurtc);
	               lbl_myogurt.setText(Item.yogurt+"");
	               MyMoney+=Integer.parseInt(yogurtc)*100000;
	               MyExp+=500*Integer.parseInt(yogurtc);
	               lbl_EXP.setText("Exp:"+MyExp);
	               lbl_Money.setText("��:"+MyMoney);
	            }
	            else
	            {
	               JOptionPane.showMessageDialog(null, "���� ����!", "���� ����", JOptionPane.WARNING_MESSAGE);
	            }
	         }
	      });
	      btn_myogurt.setBounds(642, 399, 104, 79);
	      item_panel.add(btn_myogurt);
	      
	      JButton btn_msausage = new JButton(new ImageIcon("Image/�ҽ���.png"));
	      ImageButton(btn_msausage);
	      btn_msausage.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent arg0) {
	            String sausagec = JOptionPane.showInputDialog("�Ǹ��Ͻ� �ҽ����� ������ �Է����ּ���.");
	            
	            int return_num10=JOptionPane.showConfirmDialog(null, "�ҽ��� "+sausagec+"���� �Ǹ��Ͻðڽ��ϱ�?", "Ȯ��", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	            if(return_num10==0)
	            {
	               Item.sausage-=Integer.parseInt(sausagec);
	               lbl_msausage.setText(Item.sausage+"");
	               MyMoney+=Integer.parseInt(sausagec)*500000;
	               MyExp+=200*Integer.parseInt(sausagec);
	               lbl_EXP.setText("Exp:"+MyExp);
	               lbl_Money.setText("��:"+MyMoney);
	            }
	            else
	            {
	               JOptionPane.showMessageDialog(null, "���� ����!", "���� ����", JOptionPane.WARNING_MESSAGE);
	            }
	         }
	      });
	      btn_msausage.setBounds(446, 399, 104, 79);
	      item_panel.add(btn_msausage);
	      
	      JButton btn_back11 = new JButton(new ImageIcon("Image/back.png"));
	      btn_back11.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent arg0) {
	    		  getContentPane().removeAll();
	    		  getContentPane().add(game_panel);
	    		  game_panel.updateUI();
	    	  }
	      });
	      ImageButton(btn_back11);
	      btn_back11.setBounds(12, 10, 82, 64);
	      item_panel.add(btn_back11);
			
	      JButton btn_mcheese = new JButton(new ImageIcon("Image/ġ��.png"));
	      ImageButton(btn_mcheese);
	      btn_mcheese.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent arg0) {
	            String cheesec = JOptionPane.showInputDialog("�Ǹ��Ͻ� ġ���� ������ �Է����ּ���.");
	            
	            int return_num17=JOptionPane.showConfirmDialog(null, "ġ�� "+cheesec+"���� �Ǹ��Ͻðڽ��ϱ�?", "Ȯ��", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	            if(return_num17==0)
	            {
	               Item.cheese-=Integer.parseInt(cheesec);
	               lbl_mcheese.setText(Item.cheese+"");
	               MyMoney+=Integer.parseInt(cheesec)*100000;
	               MyExp+=500*Integer.parseInt(cheesec);
	               lbl_EXP.setText("Exp:"+MyExp);
	               lbl_Money.setText("��:"+MyMoney);
	            }
	            else
	            {
	               JOptionPane.showMessageDialog(null, "���� ����!", "���� ����", JOptionPane.WARNING_MESSAGE);
	            }
	         }
	      });
	      btn_mcheese.setBounds(59, 399, 104, 79);
	      item_panel.add(btn_mcheese);
	      
	      JButton btn_mlfeed = new JButton(new ImageIcon("Image/������.png"));
	      ImageButton(btn_mlfeed);
	      btn_mlfeed.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent arg0) {
	            String lfeedc = JOptionPane.showInputDialog("�Ǹ��Ͻ� �������� ������ �Է����ּ���.");
	            
	            int return_num10=JOptionPane.showConfirmDialog(null, "������ "+lfeedc+"���� �Ǹ��Ͻðڽ��ϱ�?", "Ȯ��", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	            if(return_num10==0)
	            {
	               Item.lfeed-=Integer.parseInt(lfeedc);
	               lbl_mlfeed.setText(Item.lfeed+"");
	               MyMoney+=Integer.parseInt(lfeedc)*500;
	               lbl_Money.setText("��:"+MyMoney);
	            }
	            else
	            {
	               JOptionPane.showMessageDialog(null, "���� ����!", "���� ����", JOptionPane.WARNING_MESSAGE);
	            }
	         }
	      });
	      btn_mlfeed.setBounds(446, 92, 104, 79);
	      item_panel.add(btn_mlfeed);
	      
	      JButton btn_mhfeed = new JButton(new ImageIcon("Image/����޻��.png"));
	      ImageButton(btn_mhfeed);
	      btn_mhfeed.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent arg0) {
	            String hfeedc = JOptionPane.showInputDialog("�Ǹ��Ͻ� ��޻���� ������ �Է����ּ���.");
	            
	            int return_num10=JOptionPane.showConfirmDialog(null, "��޻�� "+hfeedc+"���� �Ǹ��Ͻðڽ��ϱ�?", "Ȯ��", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	            if(return_num10==0)
	            {
	               Item.hfeed-=Integer.parseInt(hfeedc);
	               lbl_mhfeed.setText(Item.hfeed+"");
	               MyMoney+=Integer.parseInt(hfeedc)*15000;
	               lbl_Money.setText("��:"+MyMoney);
	            }
	            else
	            {
	               JOptionPane.showMessageDialog(null, "���� ����!", "���� ����", JOptionPane.WARNING_MESSAGE);
	            }
	         }
	      });
	      btn_mhfeed.setBounds(253, 92, 104, 79);
	      item_panel.add(btn_mhfeed);
	      
	      JButton btn_mmedicine = new JButton(new ImageIcon("Image/����.png"));
	      ImageButton(btn_mmedicine);
	      btn_mmedicine.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent arg0) {
	            String medicinec = JOptionPane.showInputDialog("�Ǹ��Ͻ� ���� ������ �Է����ּ���.");
	            
	            int return_num10=JOptionPane.showConfirmDialog(null, "��"+medicinec+"���� �Ǹ��Ͻðڽ��ϱ�?", "Ȯ��", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	            if(return_num10==0)
	            {
	               Item.medicine-=Integer.parseInt(medicinec);
	               lbl_mmedicine.setText(Item.medicine+"");
	               MyMoney+=Integer.parseInt(medicinec)*3000;
	               lbl_Money.setText("��:"+MyMoney);
	            }
	            else
	            {
	               JOptionPane.showMessageDialog(null, "���� ����!", "���� ����", JOptionPane.WARNING_MESSAGE);
	            }
	         }
	      });
	      btn_mmedicine.setBounds(642, 92, 104, 79);
	      item_panel.add(btn_mmedicine);
		
	    //���� Ŭ���ϸ� ������ �г�
		JLabel lbl_Animal1_Image = new JLabel("");
		lbl_Animal1_Image.setBounds(133, 99, 192, 247);
		Animal_panel.add(lbl_Animal1_Image);
		
		JLabel lbl_Animal1_Name = new JLabel("");
		lbl_Animal1_Name.setFont(new Font("����", Font.BOLD, 17));
		lbl_Animal1_Name.setBounds(408, 54, 207, 55);
		Animal_panel.add(lbl_Animal1_Name);
		
		lbl_Animal1_Property = new JLabel("");
		lbl_Animal1_Property.setFont(new Font("����", Font.BOLD, 17));
		lbl_Animal1_Property.setBounds(408, 136, 215, 55);
		Animal_panel.add(lbl_Animal1_Property);
		
		JLabel lbl_Animal1_Avility = new JLabel("");
		lbl_Animal1_Avility.setFont(new Font("����", Font.BOLD, 17));
		lbl_Animal1_Avility.setBounds(408, 217, 225, 55);
		Animal_panel.add(lbl_Animal1_Avility);
		
		JLabel lbl_Animal1_Hp = new JLabel("");
		lbl_Animal1_Hp.setFont(new Font("����", Font.BOLD, 17));
		lbl_Animal1_Hp.setBounds(408, 301, 231, 59);
		Animal_panel.add(lbl_Animal1_Hp);
		
		JButton btn_Animal1_Heart = new JButton("\uD558\uD2B8\uC8FC\uAE30");
		btn_Animal1_Heart.setFont(new Font("����", Font.BOLD, 15));
		btn_Animal1_Heart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Animal[check].a_avility+=1;
				MyExp+=2;
				lbl_Animal1_Avility.setText("�ɷ�ġ : "+Animal[check].a_avility);
				lbl_EXP.setText("����ġ  "+MyExp);
			}
		});
		
		JButton btn_medi = new JButton("\uC57D \uBA39\uC774\uAE30");
		btn_medi.setFont(new Font("����", Font.BOLD, 15));
		btn_medi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Item.medicine>0)
				{
					Item.medicine--;
					MyExp+=30;
					Animal[check].a_hp=10;
					lbl_EXP.setText("Exp:"+MyExp);
					lbl_Animal1_Hp.setText("ü�� : "+Animal[check].a_hp);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "���� �����մϴ�!", "�� ����", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btn_medi.setBounds(654, 321, 130, 39);
		Animal_panel.add(btn_medi);
		btn_Animal1_Heart.setBounds(449, 370, 142, 41);
		Animal_panel.add(btn_Animal1_Heart);
		
		JButton btn_Animal1_Feed = new JButton("\uBA39\uC774\uC8FC\uAE30(\uBCF4\uD1B5)");
		btn_Animal1_Feed.setFont(new Font("����", Font.BOLD, 15));
		btn_Animal1_Feed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Item.lfeed>0)
				{
					Item.lfeed--;
					MyExp+=5;
					Animal[check].a_avility+=3;
					lbl_EXP.setText("Exp:"+MyExp);
					lbl_Animal1_Avility.setText("�ɷ�ġ : "+Animal[check].a_avility);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "��ᰡ �����մϴ�!", "��� ����", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btn_Animal1_Feed.setBounds(449, 423, 142, 41);
		Animal_panel.add(btn_Animal1_Feed);
		
		JButton btn_Back5 = new JButton(new ImageIcon("Image/back.png"));
		btn_Back5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				getContentPane().add(animal_panel);
				animal_panel.updateUI();
			}
		});
		btn_Back5.setBounds(12, 10, 91, 80);
		ImageButton(btn_Back5);
		Animal_panel.add(btn_Back5);
		
		JButton btn_sell = new JButton("\uD314\uAE30");
		btn_sell.setFont(new Font("����", Font.BOLD, 15));
		btn_sell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int return_num10=JOptionPane.showConfirmDialog(null, Animal[check].a_name+"��(��) ���� �Ľðڽ��ϱ�?", "Ȯ��", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(return_num10==0)
				{
					
					if(Animal[check].a_species== "��")
					{
						MyMoney+=3000+Animal[check].a_avility*1000;
						MyExp+=Animal[check].a_avility*10;
					}
					else if(Animal[check].a_species=="����")
					{
						MyMoney+=10000+Animal[check].a_avility*1000;
						MyExp+=Animal[check].a_avility*20;
					}
					else if(Animal[check].a_species=="��")
					{
						MyMoney+=50000+Animal[check].a_avility*1000;
						MyExp+=Animal[check].a_avility*30;
					}
					else if(Animal[check].a_species=="����")
					{ 
						MyMoney+=100000+Animal[check].a_avility*1000;
						MyExp+=Animal[check].a_avility*40;
					}
					else if(Animal[check].a_species=="����")
					{
						MyMoney+=150000+Animal[check].a_avility*1000;
						MyExp+=Animal[check].a_avility*50;
					}
					
					if(check==count-1)
					{
						btn_MA[check].setIcon(null);
						btn_MA[check].setText("");
						btn_CO[check].setIcon(null);
						btn_CO[check].setText("");
						
						Animal[check].a_avility=0;
						Animal[check].a_name=null;
						Animal[check].a_image=null;
						Animal[check].a_hp=0;
						Animal[check].a_property=null;
						Animal[check].a_species=null;
					}
					for(int i=check;i<count-1;i++)
					{	
						btn_MA[i+1].setIcon(null);
						btn_MA[i+1].setText("");
						btn_CO[i+1].setIcon(null);
						btn_CO[i+1].setText("");
						
						Animal[i].a_avility=Animal[i+1].a_avility;
						Animal[i].a_name=Animal[i+1].a_name;
						Animal[i].a_image=Animal[i+1].a_image;
						Animal[i].a_hp=Animal[i+1].a_hp;
						Animal[i].a_property=Animal[i+1].a_property;
						Animal[i].a_species=Animal[i+1].a_species;
						
						btn_MA[i].setIcon(Animal[i].a_image);
						btn_MA[i].setText(Animal[i].a_name);
						btn_CO[i].setIcon(Animal[i].a_image);
						btn_CO[i].setText(Animal[i].a_name);
					}
					
					
					getContentPane().removeAll();
					getContentPane().add(animal_panel);
					animal_panel.updateUI();
					lbl_Money.setText("��:"+MyMoney);
					lbl_EXP.setText("Exp:"+MyExp);
					
					count--;
				}
			}
		});
		btn_sell.setBounds(654, 423, 130, 41);
		Animal_panel.add(btn_sell);
		
		JButton btn_c_name = new JButton("\uC774\uB984 \uBC14\uAFB8\uAE30");
		btn_c_name.setFont(new Font("����", Font.BOLD, 15));
		btn_c_name.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String animal_name_change = JOptionPane.showInputDialog("���� �� �̸��� �Է��� �ּ���.");
				Animal[check].a_name=animal_name_change;
				lbl_Animal1_Name.setText("�̸� : "+Animal[check].a_name);
			}
		});
		btn_c_name.setBounds(654, 65, 130, 43);
		Animal_panel.add(btn_c_name);
		
		JButton btn_lfeed = new JButton("\uBA39\uC774\uC8FC\uAE30(\uACE0\uAE09)");
		btn_lfeed.setFont(new Font("����", Font.BOLD, 15));
		btn_lfeed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Item.hfeed>0)
				{
					Item.hfeed--;
					MyExp+=150;
					Animal[check].a_avility+=100;
					lbl_EXP.setText("Exp:"+MyExp);
					lbl_Animal1_Avility.setText("�ɷ�ġ : "+Animal[check].a_avility);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "��ᰡ �����մϴ�!", "��� ����", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btn_lfeed.setBounds(449, 476, 142, 41);
		Animal_panel.add(btn_lfeed);
			
		//���� �г�
		JButton btn_BackMake = new JButton(new ImageIcon("Image/back.png"));
		btn_BackMake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(game_panel);
				game_panel.updateUI();
			}
		});
		btn_BackMake.setBounds(25, 26, 62, 60);
		ImageButton(btn_BackMake);
		make_panel.add(btn_BackMake);
		
		JLabel lbl_MakeTitle = new JLabel("\uACF5\uBC29");
		lbl_MakeTitle.setFont(new Font("�޸յձ�������", Font.PLAIN, 52));
		lbl_MakeTitle.setBounds(352, 37, 118, 86);
		make_panel.add(lbl_MakeTitle);
		

		JButton btn_Make1 = new JButton(new ImageIcon("Image/��_����.png"));
		btn_Make1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Item.wool<3)
					JOptionPane.showMessageDialog(null, "������ �����մϴ�!", "��� ����", JOptionPane.WARNING_MESSAGE);
				else
				{
					int return_num6=JOptionPane.showConfirmDialog(null, "���� �����Ͻðڽ��ϱ�?(���� 3�� �ҿ�)", "Ȯ��", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(return_num6==0)
					{
						MyExp+=30;
						lbl_EXP.setText("Exp:"+MyExp);
						Item.wool-=3;
						Item.yarn+=1;
						lbl_mwool.setText(Item.wool+"");
						lbl_myarn.setText(Item.yarn+"");
					}
				}
			}
		});
		btn_Make1.setBounds(75, 135, 332, 192);
		ImageButton(btn_Make1);
		make_panel.add(btn_Make1);
		
		JButton btn_Make2 = new JButton(new ImageIcon("Image/�ҽ���_����.png"));
		btn_Make2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Item.meet<3)
					JOptionPane.showMessageDialog(null, "��Ⱑ �����մϴ�!", "��� ����", JOptionPane.WARNING_MESSAGE);
				else
				{
					int return_num6=JOptionPane.showConfirmDialog(null, "�ҽ����� �����Ͻðڽ��ϱ�?(��� 3�� �ҿ�)", "Ȯ��", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(return_num6==0)
					{
						MyExp+=30;
						lbl_EXP.setText("Exp:"+MyExp);
						Item.meet-=3;
						Item.sausage+=1;
						lbl_mmeet.setText(Item.meet+"");
						lbl_msausage.setText(Item.sausage+"");
					}
				}
			}
		});
		btn_Make2.setBounds(421, 135, 332, 192);
		ImageButton(btn_Make2);
		make_panel.add(btn_Make2);
		
		JButton btn_Make3 = new JButton(new ImageIcon("Image/ġ��_����.png"));
		btn_Make3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Item.milk<3)
					JOptionPane.showMessageDialog(null, "������ �����մϴ�!", "��� ����", JOptionPane.WARNING_MESSAGE);
				else
				{
					int return_num6=JOptionPane.showConfirmDialog(null, "ġ� �����Ͻðڽ��ϱ�?(���� 3�� �ҿ�)", "Ȯ��", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(return_num6==0)
					{
						MyExp+=30;
						lbl_EXP.setText("Exp:"+MyExp);
						Item.milk-=3;
						Item.cheese+=1;
						lbl_mcheese.setText(Item.cheese+"");
						lbl_mmilk.setText(Item.milk+"");
					}
				}
			}
		});
		btn_Make3.setBounds(75, 328, 332, 192);
		ImageButton(btn_Make3);
		make_panel.add(btn_Make3);
		
		JButton btn_Make4 = new JButton(new ImageIcon("Image/�䱸��Ʈ_����.png"));
		btn_Make4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Item.milk<3)
					JOptionPane.showMessageDialog(null, "������ �����մϴ�!", "��� ����", JOptionPane.WARNING_MESSAGE);
				else
				{
					int return_num6=JOptionPane.showConfirmDialog(null, "�䱸��Ʈ�� �����Ͻðڽ��ϱ�?(���� 3�� �ҿ�)", "Ȯ��", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(return_num6==0)
					{
						MyExp+=30;
						lbl_EXP.setText("Exp:"+MyExp);
						Item.milk-=3;
						Item.yogurt+=1;
						lbl_myogurt.setText(Item.yogurt+"");
						lbl_mmilk.setText(Item.milk+"");
					}
				}
			}
		});
		btn_Make4.setBounds(421, 328, 332, 192);
		ImageButton(btn_Make4);
		make_panel.add(btn_Make4);
		
		//���� �г�
		JButton btn_Back_Help = new JButton(new ImageIcon("Image/back.png"));
		btn_Back_Help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(game_panel);
				game_panel.updateUI();
			}
		});
		btn_Back_Help.setBounds(14, 27, 62, 60);
		ImageButton(btn_Back_Help);
		Help_panel.add(btn_Back_Help);
		
		JLabel lbl_HelpTitle = new JLabel("\uB3C4\uC6C0\uB9D0");
		lbl_HelpTitle.setFont(new Font("�޸յձ�������", Font.PLAIN, 53));
		lbl_HelpTitle.setBounds(341, 29, 168, 76);
		Help_panel.add(lbl_HelpTitle);
		
		JTabbedPane tab_help = new JTabbedPane(JTabbedPane.TOP);
		tab_help.setBounds(39, 126, 771, 402);
		Help_panel.add(tab_help);
		
		JPanel Panel_H2 = new JPanel();
		Panel_H2.setBackground(new Color(156, 207, 200));
		tab_help.addTab(" �������� ", Panel_H2);
		Panel_H2.setLayout(null);
		
		JTextArea ta2 = new JTextArea();
		ta2.setFont(new Font("����", Font.BOLD, 18));
		ta2.setEditable(false);
		ta2.setBounds(39, 38, 686, 302);
		Panel_H2.add(ta2);
		
		JPanel Panel_H3 = new JPanel();
		Panel_H3.setBackground(new Color(156, 207, 200));
		tab_help.addTab("  �ζ�  ", Panel_H3);
		Panel_H3.setLayout(null);
		
		JTextArea ta3 = new JTextArea();
		ta3.setFont(new Font("����", Font.BOLD, 18));
		ta3.setEditable(false);
		ta3.setBounds(39, 38, 686, 302);
		Panel_H3.add(ta3);
		
		JPanel Panel_H4 = new JPanel();
		Panel_H4.setBackground(new Color(156, 207, 200));
		tab_help.addTab(" �λ깰 ", Panel_H4);
		Panel_H4.setLayout(null);
		
		JTextArea ta4 = new JTextArea();
		ta4.setFont(new Font("����", Font.BOLD, 18));
		ta4.setEditable(false);
		ta4.setBounds(39, 38, 686, 302);
		Panel_H4.add(ta4);
		
		JPanel Panel_H5 = new JPanel();
		Panel_H5.setBackground(new Color(156, 207, 200));
		tab_help.addTab("  ����  ", Panel_H5);
		Panel_H5.setLayout(null);
		
		JTextArea ta5 = new JTextArea();
		ta5.setFont(new Font("����", Font.BOLD, 18));
		ta5.setEditable(false);
		ta5.setBounds(39, 38, 686, 302);
		Panel_H5.add(ta5);
		
		JPanel Panel_H6 = new JPanel();
		Panel_H6.setBackground(new Color(156, 207, 200));
		tab_help.addTab("  ����  ", Panel_H6);
		Panel_H6.setLayout(null);
		
		JTextArea ta6 = new JTextArea();
		ta6.setFont(new Font("����", Font.BOLD, 18));
		ta6.setEditable(false);
		ta6.setBounds(39, 38, 686, 302);
		Panel_H6.add(ta6);
		
		JPanel Panel_H7 = new JPanel();
		Panel_H7.setBackground(new Color(156, 207, 200));
		tab_help.addTab(" ���׽�Ʈ ", Panel_H7);
		Panel_H7.setLayout(null);
		
		JTextArea ta7 = new JTextArea();
		ta7.setFont(new Font("����", Font.BOLD, 18));
		ta7.setEditable(false);
		ta7.setBounds(39, 38, 686, 302);
		Panel_H7.add(ta7);
		
		JPanel Panel_H1 = new JPanel();
		Panel_H1.setBackground(new Color(156, 207, 200));
		tab_help.addTab(" �� ȹ�� ", Panel_H1);
		Panel_H1.setLayout(null);
		
		JTextArea ta1 = new JTextArea();
		ta1.setFont(new Font("����", Font.BOLD, 18));
		ta1.setEditable(false);
		ta1.setBounds(39, 38, 686, 302);
		Panel_H1.add(ta1);	
		
		//�ζ� �г�
		JButton btn_Entry = new JButton("\uAD6C\uB9E4\uD558\uAE30(5000\uC6D0)");
		btn_Entry.setBackground(Color.WHITE);
		btn_Entry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int []input_num=new int[6];
				if(MyMoney<5000)
				{
					JOptionPane.showMessageDialog(null, "���� �����մϴ�.", "�� ����", JOptionPane.WARNING_MESSAGE);
					tf_num1.setText("");
					tf_num2.setText("");
					tf_num3.setText("");
					tf_num4.setText("");
					tf_num5.setText("");
					tf_num6.setText("");
				}
				else
				{
					btn_Entry.setEnabled(true);
					if(tf_num1.getText().equals("")||tf_num2.getText().equals("")||tf_num3.getText().equals("")||tf_num4.getText().equals("")||tf_num5.getText().equals("")||tf_num6.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "�� ĭ�� �ֽ��ϴ�. ���ڸ� �Է����ּ���.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
					}
					else
					{
						input_num[0]=Integer.parseInt(tf_num1.getText());
						input_num[1]=Integer.parseInt(tf_num2.getText());
						input_num[2]=Integer.parseInt(tf_num3.getText());
						input_num[3]=Integer.parseInt(tf_num4.getText());
						input_num[4]=Integer.parseInt(tf_num5.getText());
						input_num[5]=Integer.parseInt(tf_num6.getText());
						
						MyMoney-=5000;
						Store_btnset2(btn_F1, btn_F2, btn_F3);
						Store_btnset(btn_A1, btn_A2, btn_A3, btn_A4, btn_A5);
						Lotto(input_num);
						tf_num1.setText("");
						tf_num2.setText("");
						tf_num3.setText("");
						tf_num4.setText("");
						tf_num5.setText("");
						tf_num6.setText("");
					}
				}
				
			}
		});
		btn_Entry.setBounds(318, 284, 147, 34);
		Panel_l.add(btn_Entry);
		
		tf_num1 = new JTextField();
		tf_num1.setBounds(199, 181, 51, 34);
		Panel_l.add(tf_num1);
		tf_num1.setColumns(10);
		
		tf_num2 = new JTextField();
		tf_num2.setColumns(10);
		tf_num2.setBounds(267, 181, 51, 34);
		Panel_l.add(tf_num2);
		
		tf_num3 = new JTextField();
		tf_num3.setColumns(10);
		tf_num3.setBounds(335, 181, 51, 34);
		Panel_l.add(tf_num3);
		
		tf_num4 = new JTextField();
		tf_num4.setColumns(10);
		tf_num4.setBounds(400, 181, 51, 34);
		Panel_l.add(tf_num4);
		
		tf_num5 = new JTextField();
		tf_num5.setColumns(10);
		tf_num5.setBounds(465, 181, 51, 34);
		Panel_l.add(tf_num5);
		
		tf_num6 = new JTextField();
		tf_num6.setColumns(10);
		tf_num6.setBounds(529, 181, 51, 34);
		Panel_l.add(tf_num6);
		
		JLabel lblNewLabel = new JLabel("1~45\uAE4C\uC9C0\uC758 \uC22B\uC790 6\uAC1C\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694");
		lblNewLabel.setFont(new Font("����", Font.BOLD, 18));
		lblNewLabel.setBounds(221, 98, 337, 28);
		Panel_l.add(lblNewLabel);
		
		btn_F1 = new JButton(new ImageIcon("Image/���.png"));
		btn_F1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int return_num6=JOptionPane.showConfirmDialog(null, "��Ḧ ���� �Ͻðڽ��ϱ�?", "Ȯ��", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(return_num6==0)
				{
					MyExp+=3;
					lbl_EXP.setText("Exp:"+MyExp);
					MyMoney=MyMoney-500;
					Item.lfeed++;
					lbl_mlfeed.setText(Item.lfeed+"");
					Store_btnset2(btn_F1, btn_F2, btn_F3);
					Store_btnset(btn_A1, btn_A2, btn_A3, btn_A4, btn_A5);
				}
			}
		});
		btn_F1.setBounds(14, 12, 249, 177);
		ImageButton(btn_F1);
		Panel_f.add(btn_F1);
		
		btn_F2 = new JButton(new ImageIcon("Image/��޻��.png"));
		btn_F2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int return_num6=JOptionPane.showConfirmDialog(null, "��޻�Ḧ ���� �Ͻðڽ��ϱ�?", "Ȯ��", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(return_num6==0)
				{
					MyExp+=50;
					lbl_EXP.setText("Exp:"+MyExp);
					MyMoney=MyMoney-15000;
					Item.hfeed++;
					lbl_mhfeed.setText(Item.hfeed+"");
					Store_btnset2(btn_F1, btn_F2, btn_F3);
					Store_btnset(btn_A1, btn_A2, btn_A3, btn_A4, btn_A5);
				}
			}
		});
		btn_F2.setBounds(288, 12, 249, 177);
		ImageButton(btn_F2);
		Panel_f.add(btn_F2);
		
		btn_F3 = new JButton(new ImageIcon("Image/��.png"));
		btn_F3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int return_num6=JOptionPane.showConfirmDialog(null, "���� ���� �Ͻðڽ��ϱ�?", "Ȯ��", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(return_num6==0)
				{
					MyExp+=5;
					lbl_EXP.setText("Exp:"+MyExp);
					MyMoney=MyMoney-3000;
					Item.medicine++;
					lbl_mmedicine.setText(Item.medicine+"");
					Store_btnset2(btn_F1, btn_F2, btn_F3);
					Store_btnset(btn_A1, btn_A2, btn_A3, btn_A4, btn_A5);
				}
			}
		});
		btn_F3.setBounds(551, 12, 249, 177);
		ImageButton(btn_F3);
		Panel_f.add(btn_F3);
		
		JLabel lbl_storeTitle = new JLabel("\uC0C1\uC810");
		lbl_storeTitle.setFont(new Font("�޸յձ�������", Font.PLAIN, 53));
		lbl_storeTitle.setBounds(359, 31, 106, 54);
		store_panel.add(lbl_storeTitle);
		
		JButton btn_BackStore = new JButton(new ImageIcon("Image/back.png"));
		btn_BackStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(game_panel);
				game_panel.updateUI();
			}
		});
		ImageButton(btn_BackStore);
		btn_BackStore.setBounds(14, 25, 62, 60);
		store_panel.add(btn_BackStore);
			
		ImageIcon c=new ImageIcon("Image/��.png");
		ImageIcon d=new ImageIcon("Image/����.png");
		ImageIcon w=new ImageIcon("Image/����.png");
		ImageIcon s=new ImageIcon("Image/��.png");
		ImageIcon p=new ImageIcon("Image/����.png");
		
		btn_A1 = new AnimalAddButton(mainview_panel, "��");
		btn_A1.setBounds(14, 12, 249, 177);
		Panel_a.add(btn_A1);
		
		btn_A2 = new AnimalAddButton(mainview_panel, "����");
		btn_A2.setBounds(287, 12, 249, 177);
		Panel_a.add(btn_A2);
		
		btn_A3 = new AnimalAddButton(mainview_panel, "��");
		btn_A3.setBounds(554, 12, 249, 177);
		Panel_a.add(btn_A3);
		
		btn_A4 = new AnimalAddButton(mainview_panel, "����");
		btn_A4.setBounds(14, 210, 249, 177);
		Panel_a.add(btn_A4);
		
		btn_A5 = new AnimalAddButton(mainview_panel, "����");
		btn_A5.setBounds(287, 210, 249, 177);
		Panel_a.add(btn_A5);
		
		JButton btn_A6 = new JButton(new ImageIcon("Image/����ǥ.png"));
		btn_A6.setBounds(554, 210, 249, 177);
		ImageButton(btn_A6);
		btn_A6.setEnabled(false);
		Panel_a.add(btn_A6);
		
		lbl_Money_store = new JLabel("");
		lbl_Money_store.setFont(new Font("����", Font.BOLD, 16));
		lbl_Money_store.setBounds(675, 31, 158, 26);
		store_panel.add(lbl_Money_store);
		
		//���� �г�
		JButton btn_Repay = new JButton("\uBE5A \uAC1A\uAE30");
		btn_Repay.setFont(new Font("����", Font.BOLD, 17));
		btn_Repay.setBackground(Color.WHITE);
		btn_Repay.addActionListener(new ActionListener() {
	           public void actionPerformed(ActionEvent arg0) {
	              String repay = JOptionPane.showInputDialog("�󸶸� �����ðڽ��ϱ�?");
	              if(Integer.parseInt(repay)>MyMoney)
	              {
	                 JOptionPane.showMessageDialog(null, "���� �����մϴ�!", "�� ����", JOptionPane.WARNING_MESSAGE);
	              }
	              else
	              {
	                 MyDebt-=Integer.parseInt(repay);
	                 MyMoney-=Integer.parseInt(repay);
	                 MyExp+=0.01*Integer.parseInt(repay);
	                 lbl_EXP.setText("Exp:"+MyExp);
	                 MyMoney(MyMoney);
	                 MyDebt(MyDebt);
	                 lbl_Money_bank.setText("��: "+MyMoney);
	                 if(MyDebt<0&&MyMoney>0)
	                 {
	                    int return_num5=JOptionPane.showConfirmDialog(null, "���� û���ϼ̽��ϴ�!\n������ �Ǹ��Ͻðڽ��ϱ�?", "Ȯ��", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	                if(return_num5==0)
	                {
	                   getContentPane().removeAll();
	                 getContentPane().add(ending_panel);
	                 ending_panel.updateUI();
	                 Ending(lbl_EndingTitle, ta_Eding, 4);
	                 btn_EC1.setEnabled(true);
	                 btn_EC1.setIcon(new ImageIcon("Image/ending5.png"));
	                 lbl_et1.setText("5. �ǹ���");
	                 for(int i=0;i<10;i++)
	               {
	                  Animal[i].a_avility=0;
	                  Animal[i].a_hp=10;
	                  Animal[i].a_name=null;
	                  Animal[i].a_image=null;
	                  Animal[i].a_property=null;
	                  Animal[i].a_species=null;
	                  btn_MA[i].setIcon(null);
	                  btn_MA[i].setText("");
	                  btn_CO[i].setIcon(null);
	                  btn_CO[i].setText("");
	               }
	                 MyMoney=10000;
	               MyDebt=100000000;
	               lbl_Money.setText("��:"+MyMoney);
	               lbl_Debt.setText("��:"+MyDebt);
	                }
	                else
	                {
	                   if(win>=10)
	                   {
	                      getContentPane().removeAll();
	                         getContentPane().add(ending_panel);
	                         ending_panel.updateUI();
	                         Ending(lbl_EndingTitle, ta_Eding, 3);
	                         btn_EC1.setEnabled(true);
	                         btn_EC1.setIcon(new ImageIcon("Image/ending4.png"));
	                         lbl_et1.setText("4. �ְ��� ���� ������");
	                         for(int i=0;i<10;i++)
	                       {
	                          Animal[i].a_avility=0;
	                          Animal[i].a_hp=10;
	                          Animal[i].a_name=null;
	                          Animal[i].a_image=null;
	                          Animal[i].a_property=null;
	                          Animal[i].a_species=null;
	                          btn_MA[i].setIcon(null);
	                          btn_MA[i].setText("");
	                          btn_CO[i].setIcon(null);
	                          btn_CO[i].setText("");
	                       }
	                         MyMoney=10000;
	                       MyDebt=100000000;
	                       lbl_Money.setText("��:"+MyMoney);
	                       lbl_Debt.setText("��:"+MyDebt);
	                   }
	                   else
	                   {
	                   getContentPane().removeAll();
	                     getContentPane().add(ending_panel);
	                     ending_panel.updateUI();
	                     Ending(lbl_EndingTitle, ta_Eding, 2);
	                     btn_EC1.setEnabled(true);
	                     btn_EC1.setIcon(new ImageIcon("Image/ending3.png"));
	                     lbl_et1.setText("3. �鸸����");
	                     for(int i=0;i<10;i++)
	                   {
	                      Animal[i].a_avility=0;
	                      Animal[i].a_hp=10;
	                      Animal[i].a_name=null;
	                      Animal[i].a_image=null;
	                      Animal[i].a_property=null;
	                      Animal[i].a_species=null;
	                      btn_MA[i].setIcon(null);
	                      btn_MA[i].setText("");
	                      btn_CO[i].setIcon(null);
	                      btn_CO[i].setText("");
	                   }
	                     MyMoney=10000;
	                   MyDebt=100000000;
	                   lbl_Money.setText("��:"+MyMoney);
	                   lbl_Debt.setText("��:"+MyDebt);
	                   }
	                }
	                 }
	              }
	           }
	        });
        
        JButton btn_Loan = new JButton("\uB300\uCD9C \uD558\uAE30");
        btn_Loan.setFont(new Font("����", Font.BOLD, 17));
        btn_Loan.setBackground(Color.WHITE);
        btn_Loan.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent arg0) {
              String loan =JOptionPane.showInputDialog("�󸶸� �����ðڽ��ϱ�?");
              MyMoney+=Integer.parseInt(loan);
              MyDebt+=Integer.parseInt(loan);
              MyDebt(MyDebt);
              MyMoney(MyMoney);
              lbl_Money_bank.setText("��: "+MyMoney);
           }
        });
        btn_Loan.setBounds(506, 193, 117, 34);
        bank_panel.add(btn_Loan);
        btn_Repay.setBounds(506, 140, 117, 34);
        bank_panel.add(btn_Repay);
        
        ImageIcon Banking=new ImageIcon("Image/banking.png");
        JLabel lbl_Bank_Person = new JLabel(Banking);
        lbl_Bank_Person.setBounds(59, 221, 310, 288);
        bank_panel.add(lbl_Bank_Person);
            
        ImageIcon chat= new ImageIcon("Image/chat.png");
        JLabel lbl_Chat = new JLabel(chat) ;
        lbl_Chat.setBounds(364, 67, 399, 343);
        bank_panel.add(lbl_Chat);
		
    	
		JButton btn_BackBank = new JButton(new ImageIcon("Image/back.png"));
		btn_BackBank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				getContentPane().add(game_panel);
				game_panel.updateUI();
			}
		});
		btn_BackBank.setBounds(14, 24, 62, 60);
		ImageButton(btn_BackBank);
		bank_panel.add(btn_BackBank);
		
		JLabel lbl_BankTitle = new JLabel("\uC740\uD589");
		lbl_BankTitle.setFont(new Font("�޸յձ�������", Font.PLAIN, 53));
		lbl_BankTitle.setBounds(371, 24, 106, 76);
		bank_panel.add(lbl_BankTitle);
		
		lbl_Money_bank = new JLabel("\uB3C8");
		lbl_Money_bank.setFont(new Font("����", Font.BOLD, 17));
		lbl_Money_bank.setBounds(623, 43, 177, 32);
		bank_panel.add(lbl_Money_bank);
		
		//���� �г�
		JLabel label_4 = new JLabel("\uB0B4 \uB3D9\uBB3C");
		label_4.setFont(new Font("�޸յձ�������", Font.PLAIN, 53));
		label_4.setBounds(316, 37, 191, 54);
		animal_panel.add(label_4);
		
		JButton button_1 = new JButton(new ImageIcon("Image/back.png"));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(game_panel);
				game_panel.updateUI();
			}
		});
		ImageButton(button_1);
		button_1.setBounds(27, 31, 62, 60);
		animal_panel.add(button_1);
		
		for(int i=0;i<10;i++)
			btn_MA[i]=new JButton("");
		btn_MA[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Animal[0].a_name==null)
				{
					JOptionPane.showMessageDialog(null, "������ �������� �ʽ��ϴ�!", "���� ���� X", JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					check=0;
					getContentPane().removeAll();
					getContentPane().add(Animal_panel);
					Animal_panel.updateUI();
					lbl_Animal1_Name.setText("�̸� : "+Animal[0].a_name);
					lbl_Animal1_Image.setIcon(Animal[0].a_image);
					lbl_Animal1_Property.setText("���� : "+Animal[0].a_property);
					lbl_Animal1_Avility.setText("�ɷ�ġ : "+Animal[0].a_avility);
					lbl_Animal1_Hp.setText("ü�� : "+Animal[0].a_hp);
				}
			}
		});
		btn_MA[0].setBounds(27, 120, 130, 183);
		animal_panel.add(btn_MA[0]);
		
		btn_MA[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Animal[1].a_name==null)
				{
					JOptionPane.showMessageDialog(null, "������ �������� �ʽ��ϴ�!", "���� ���� X", JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					check=1;
					getContentPane().removeAll();
					getContentPane().add(Animal_panel);
					Animal_panel.updateUI();
					lbl_Animal1_Name.setText("�̸� : "+Animal[1].a_name);
					lbl_Animal1_Image.setIcon(Animal[1].a_image);
					lbl_Animal1_Property.setText("���� : "+Animal[1].a_property);
					lbl_Animal1_Avility.setText("�ɷ�ġ : "+Animal[1].a_avility);
					lbl_Animal1_Hp.setText("ü�� : "+Animal[1].a_hp);
				}
			}
		});
		btn_MA[1].setBounds(186, 120, 130, 183);
		animal_panel.add(btn_MA[1]);
		
		btn_MA[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Animal[2].a_name==null)
				{
					JOptionPane.showMessageDialog(null, "������ �������� �ʽ��ϴ�!", "���� ���� X", JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					check=2;
					getContentPane().removeAll();
					getContentPane().add(Animal_panel);
					Animal_panel.updateUI();
					lbl_Animal1_Name.setText("�̸� : "+Animal[2].a_name);
					lbl_Animal1_Image.setIcon(Animal[2].a_image);
					lbl_Animal1_Property.setText("���� : "+Animal[2].a_property);
					lbl_Animal1_Avility.setText("�ɷ�ġ : "+Animal[2].a_avility);
					lbl_Animal1_Hp.setText("ü�� : "+Animal[2].a_hp);
				}
			}
		});
		btn_MA[2].setBounds(352, 120, 130, 183);
		animal_panel.add(btn_MA[2]);
		
		btn_MA[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Animal[3].a_name==null)
				{
					JOptionPane.showMessageDialog(null, "������ �������� �ʽ��ϴ�!", "���� ���� X", JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					check=3;
					getContentPane().removeAll();
					getContentPane().add(Animal_panel);
					Animal_panel.updateUI();
					lbl_Animal1_Name.setText("�̸� : "+Animal[3].a_name);
					lbl_Animal1_Image.setIcon(Animal[3].a_image);
					lbl_Animal1_Property.setText("���� : "+Animal[3].a_property);
					lbl_Animal1_Avility.setText("�ɷ�ġ : "+Animal[3].a_avility);
					lbl_Animal1_Hp.setText("ü�� : "+Animal[3].a_hp);
				}
			}
		});
		btn_MA[3].setBounds(517, 120, 130, 183);
		animal_panel.add(btn_MA[3]);
		
		btn_MA[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Animal[4].a_name==null)
				{
					JOptionPane.showMessageDialog(null, "������ �������� �ʽ��ϴ�!", "���� ���� X", JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					check=4;
					getContentPane().removeAll();
					getContentPane().add(Animal_panel);
					Animal_panel.updateUI();
					lbl_Animal1_Name.setText("�̸� : "+Animal[4].a_name);
					lbl_Animal1_Image.setIcon(Animal[4].a_image);
					lbl_Animal1_Property.setText("���� : "+Animal[4].a_property);
					lbl_Animal1_Avility.setText("�ɷ�ġ : "+Animal[4].a_avility);
					lbl_Animal1_Hp.setText("ü�� : "+Animal[4].a_hp);
				}
			}
		});
		btn_MA[4].setBounds(687, 120, 130, 183);
		animal_panel.add(btn_MA[4]);
		
		btn_MA[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Animal[5].a_name==null)
				{
					JOptionPane.showMessageDialog(null, "������ �������� �ʽ��ϴ�!", "���� ���� X", JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					check=5;
					getContentPane().removeAll();
					getContentPane().add(Animal_panel);
					Animal_panel.updateUI();
					lbl_Animal1_Name.setText("�̸� : "+Animal[5].a_name);
					lbl_Animal1_Image.setIcon(Animal[5].a_image);
					lbl_Animal1_Property.setText("���� : "+Animal[5].a_property);
					lbl_Animal1_Avility.setText("�ɷ�ġ : "+Animal[5].a_avility);
					lbl_Animal1_Hp.setText("ü�� : "+Animal[5].a_hp);
				}
			}
		});
		btn_MA[5].setBounds(27, 333, 130, 183);
		animal_panel.add(btn_MA[5]);
		
		btn_MA[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Animal[6].a_name==null)
				{
					JOptionPane.showMessageDialog(null, "������ �������� �ʽ��ϴ�!", "���� ���� X", JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					check=6;
					getContentPane().removeAll();
					getContentPane().add(Animal_panel);
					Animal_panel.updateUI();
					lbl_Animal1_Name.setText("�̸� : "+Animal[6].a_name);
					lbl_Animal1_Image.setIcon(Animal[6].a_image);
					lbl_Animal1_Property.setText("���� : "+Animal[6].a_property);
					lbl_Animal1_Avility.setText("�ɷ�ġ : "+Animal[6].a_avility);
					lbl_Animal1_Hp.setText("ü�� : "+Animal[6].a_hp);
				}
			}
		});
		btn_MA[6].setBounds(186, 333, 130, 183);
		animal_panel.add(btn_MA[6]);
		
		btn_MA[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Animal[7].a_name==null)
				{
					JOptionPane.showMessageDialog(null, "������ �������� �ʽ��ϴ�!", "���� ���� X", JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					check=7;
					getContentPane().removeAll();
					getContentPane().add(Animal_panel);
					Animal_panel.updateUI();
					lbl_Animal1_Name.setText("�̸� : "+Animal[7].a_name);
					lbl_Animal1_Image.setIcon(Animal[7].a_image);
					lbl_Animal1_Property.setText("���� : "+Animal[7].a_property);
					lbl_Animal1_Avility.setText("�ɷ�ġ : "+Animal[7].a_avility);
					lbl_Animal1_Hp.setText("ü�� : "+Animal[7].a_hp);
				}
			}
		});
		btn_MA[7].setBounds(352, 333, 130, 183);
		animal_panel.add(btn_MA[7]);
		
		btn_MA[8].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Animal[8].a_name==null)
				{
					JOptionPane.showMessageDialog(null, "������ �������� �ʽ��ϴ�!", "���� ���� X", JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					check=8;
					getContentPane().removeAll();
					getContentPane().add(Animal_panel);
					Animal_panel.updateUI();
					lbl_Animal1_Name.setText("�̸� : "+Animal[8].a_name);
					lbl_Animal1_Image.setIcon(Animal[8].a_image);
					lbl_Animal1_Property.setText("���� : "+Animal[8].a_property);
					lbl_Animal1_Avility.setText("�ɷ�ġ : "+Animal[8].a_avility);
					lbl_Animal1_Hp.setText("ü�� : "+Animal[8].a_hp);
				}
			}
		});
		btn_MA[8].setBounds(517, 333, 130, 183);
		animal_panel.add(btn_MA[8]);
		
		btn_MA[9].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Animal[9].a_name==null)
				{
					JOptionPane.showMessageDialog(null, "������ �������� �ʽ��ϴ�!", "���� ���� X", JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					check=9;
					getContentPane().removeAll();
					getContentPane().add(Animal_panel);
					Animal_panel.updateUI();
					lbl_Animal1_Name.setText("�̸� : "+Animal[9].a_name);
					lbl_Animal1_Image.setIcon(Animal[9].a_image);
					lbl_Animal1_Property.setText("���� : "+Animal[9].a_property);
					lbl_Animal1_Avility.setText("�ɷ�ġ : "+Animal[9].a_avility);
					lbl_Animal1_Hp.setText("ü�� : "+Animal[9].a_hp);
				}
			}
		});
		btn_MA[9].setBounds(687, 333, 130, 183);
		animal_panel.add(btn_MA[9]);
		
		//���� ���� ǥ�� �г�
		JLabel lbl_LV = new JLabel("LV");
		lbl_LV.setFont(new Font("����", Font.BOLD, 17));
		lbl_LV.setBounds(14, 12, 61, 32);
		Mydata_panel.add(lbl_LV);
		
		JLabel lbl_ID3 = new JLabel("ID");
		lbl_ID3.setFont(new Font("����", Font.BOLD, 17));
		lbl_ID3.setBounds(78, 12, 96, 32);
		Mydata_panel.add(lbl_ID3);
		
		lbl_Debt = new JLabel("\uBE5A");
		lbl_Debt.setFont(new Font("����", Font.BOLD, 17));
		lbl_Debt.setBounds(298, 12, 147, 32);
		Mydata_panel.add(lbl_Debt);
		
		lbl_Money = new JLabel("\uB3C8");
		lbl_Money.setFont(new Font("����", Font.BOLD, 17));
		lbl_Money.setBounds(453, 12, 154, 32);
		Mydata_panel.add(lbl_Money);
		
		JButton btn_Help = new JButton(new ImageIcon("Image/����ǥ2.png"));
		btn_Help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(Help_panel);
				Help_panel.updateUI();
				Helpf(ta1, ta2, ta3, ta4, ta5, ta6, ta7);
			}
		});
		btn_Help.setBounds(786, 0, 61, 56);
		ImageButton(btn_Help);
		Mydata_panel.add(btn_Help);
		
		lbl_EXP = new JLabel("\uACBD\uD5D8\uCE58");
		lbl_EXP.setFont(new Font("����", Font.BOLD, 17));
		lbl_EXP.setBounds(176, 16, 118, 25);
		Mydata_panel.add(lbl_EXP);
		
		JLabel lbl_time = new JLabel("");
		lbl_time.setBounds(608, 12, 179, 32);
		lbl_time.setFont(new Font("����", Font.BOLD, 17));
		lbl_time.setText("2017�� 1�� 1�� 07:00");
		Mydata_panel.add(lbl_time);
		
		//�ð� ������
		class TimeThread extends Thread
		{
			int year=2017, month=1, day=1, hour=7, minutes=0;
			public void run()
			{
				while(true)
				{
					 try {
		                 sleep(3000);
		              }
		             catch(InterruptedException e){}
					 minutes+=1;
					 if(minutes==60)
					 {
						 minutes=0;
						 hour+=1;
					 }
					 if(hour==24)
					 {
						 hour=0;
						 day+=1;
						 DebtDay+=1;
						 if(DebtDay%7==0)
						 {
							 MyDebt+=MyDebt*0.02;
							 lbl_Debt.setText("��: "+MyDebt);
						 }
					 }
					 if(day==31)
					 {
						 day=1;
						 month+=1;
					 }
					 if(month==13)
					 {
						 month=1;
						 year+=1;
					 }
					 if(minutes<10&&hour<10)
						 lbl_time.setText(year+"�� "+month+"�� "+day+"�� 0"+hour+":0"+minutes);
					 else if(minutes<10)
						 lbl_time.setText(year+"�� "+month+"�� "+day+"�� "+hour+":0"+minutes);
					 else if(hour<10)
						 lbl_time.setText(year+"�� "+month+"�� "+day+"�� 0"+hour+":"+minutes);
					 else
						 lbl_time.setText(year+"�� "+month+"�� "+day+"�� "+hour+":"+minutes);
				}
			}
		}
		
		//���� �г�-��ư
		JButton btn_Bank = new JButton(new ImageIcon("Image/����.png"));
		btn_Bank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				getContentPane().add(bank_panel);
				bank_panel.updateUI();
				lbl_Money_bank.setText("��: "+MyMoney);
			}
		});
		btn_Bank.setBounds(0, 413, 119, 71);
		ImageButton(btn_Bank);
		mainview_panel.add(btn_Bank);
		
		JButton btn_Store = new JButton(new ImageIcon("Image/����.png"));
		btn_Store.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				getContentPane().add(store_panel);
				store_panel.updateUI();
				lbl_Money_store.setText("��: "+Integer.toString(MyMoney));
				Store_btnset(btn_A1, btn_A2, btn_A3, btn_A4, btn_A5);
				Store_btnset2(btn_F1, btn_F2, btn_F3);
			}
		});
		btn_Store.setBounds(122, 413, 119, 71);
		ImageButton(btn_Store);
		mainview_panel.add(btn_Store);
		
		JButton btn_MyAnimal = new JButton(new ImageIcon("Image/������.png"));
		btn_MyAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				getContentPane().add(animal_panel);
				animal_panel.updateUI();
			}
		});
		btn_MyAnimal.setBounds(244, 407, 119, 77);
		ImageButton(btn_MyAnimal);
		mainview_panel.add(btn_MyAnimal);
		
		JButton btn_MyItem = new JButton(new ImageIcon("Image/â��.png"));
		btn_MyItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item_Data(lbl_megg,lbl_mdegg,lbl_mwool,lbl_mmeet,lbl_mmilk,
						lbl_mcheese,lbl_myarn,lbl_msausage,lbl_myogurt,lbl_mhfeed,
						lbl_mlfeed,lbl_mmedicine);
				getContentPane().removeAll();
				getContentPane().add(item_panel);
				item_panel.updateUI();
			}
		});
		btn_MyItem.setBounds(365, 413, 119, 77);
		ImageButton(btn_MyItem);
		mainview_panel.add(btn_MyItem);
		
		JButton btn_Make = new JButton(new ImageIcon("Image/����.png"));
		btn_Make.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				getContentPane().add(make_panel);
				make_panel.updateUI();
			}
		});
		btn_Make.setBounds(486, 413, 119, 71);
		ImageButton(btn_Make);
		mainview_panel.add(btn_Make);
		
		JButton btn_Contest = new JButton(new ImageIcon("Image/���׽�Ʈ.png"));
		btn_Contest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(MyLV<15)
					JOptionPane.showMessageDialog(null, "���׽�Ʈ�� ���� 15�̻� ���� �����մϴ�.", "���׽�Ʈ ���� �Ұ�", JOptionPane.WARNING_MESSAGE);
				else
				{
					getContentPane().removeAll();
					getContentPane().add(contest_panel);
					contest_panel.updateUI();
				}
			}
		});
		btn_Contest.setBounds(607, 413, 119, 71);
		ImageButton(btn_Contest);
		mainview_panel.add(btn_Contest);
		
		JButton btn_GameEnd = new JButton(new ImageIcon("Image/����.png"));
		btn_GameEnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int return_num3=JOptionPane.showConfirmDialog(null, "���� �Ͻðڽ��ϱ�?", "Ȯ��", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				getContentPane().removeAll();
				getContentPane().add(user_panel);
				user_panel.updateUI();
			}
		});
		btn_GameEnd.setBounds(728, 413, 119, 71);
		ImageButton(btn_GameEnd);
		mainview_panel.add(btn_GameEnd);
		
		//���� �����Կ��� ���� �ٽú���
		JLabel lbl_ReET = new JLabel("", SwingConstants.CENTER);
		lbl_ReET.setForeground(Color.WHITE);
		lbl_ReET.setFont(new Font("�޸յձ�������", Font.PLAIN, 37));
		lbl_ReET.setBounds(108, 53, 634, 109);
		reending_panel.add(lbl_ReET);
		
		JTextArea ta_ReEnding = new JTextArea();
		ta_ReEnding.setForeground(Color.WHITE);
		ta_ReEnding.setFont(new Font("����", Font.BOLD, 22));
		ta_ReEnding.setBackground(Color.BLACK);
		ta_ReEnding.setBounds(77, 216, 682, 231);
		reending_panel.add(ta_ReEnding);
		
		JButton btn_goEC = new JButton(new ImageIcon("Image/back.png"));
		btn_goEC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(endingcollec_panel);
				endingcollec_panel.updateUI();
			}
		});
		btn_goEC.setBounds(32, 36, 69, 63);
		ImageButton(btn_goEC);
		reending_panel.add(btn_goEC);
		
		//���� ������ �г�
		JLabel lbl_ECTitle = new JLabel("\uC5D4\uB529 \uBCF4\uAD00\uD568", JLabel.CENTER);
		lbl_ECTitle.setFont(new Font("�޸յձ�������", Font.PLAIN, 62));
		lbl_ECTitle.setBounds(230, 43, 378, 80);
		endingcollec_panel.add(lbl_ECTitle);
		
		btn_EC1 = new JButton(new ImageIcon("Image/����ǥ.png"));
		btn_EC1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(reending_panel);
				reending_panel.updateUI();
				Ending(lbl_ReET, ta_ReEnding, 0);
			}
		});
		btn_EC1.setBounds(26, 143, 242, 163);
		btn_EC1.setEnabled(false);
		ImageButton(btn_EC1);
		endingcollec_panel.add(btn_EC1);
		
		btn_EC2 = new JButton(new ImageIcon("Image/����ǥ.png"));
		btn_EC2.setBounds(304, 143, 242, 163);
		btn_EC2.setEnabled(false);
		ImageButton(btn_EC2);
		endingcollec_panel.add(btn_EC2);
		
		btn_EC3 = new JButton(new ImageIcon("Image/����ǥ.png"));
		btn_EC3.setBounds(580, 143, 242, 163);
		btn_EC3.setEnabled(false);
		ImageButton(btn_EC3);
		endingcollec_panel.add(btn_EC3);
		
		btn_EC4 = new JButton(new ImageIcon("Image/����ǥ.png"));
		btn_EC4.setBounds(26, 334, 242, 163);
		btn_EC4.setEnabled(false);
		ImageButton(btn_EC4);
		endingcollec_panel.add(btn_EC4);
		
		btn_EC5 = new JButton(new ImageIcon("Image/����ǥ.png"));
		btn_EC5.setBounds(304, 334, 242, 163);
		btn_EC5.setEnabled(false);
		ImageButton(btn_EC5);
		endingcollec_panel.add(btn_EC5);
		
		JButton btn_ECBack = new JButton(new ImageIcon("Image/back.png"));
		btn_ECBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(user_panel);
				user_panel.updateUI();
			}
		});
		btn_ECBack.setBounds(26, 33, 69, 63);
		ImageButton(btn_ECBack);
		endingcollec_panel.add(btn_ECBack);
		
		JButton btn_EC6 = new JButton(new ImageIcon("Image/x.png"));
		btn_EC6.setBounds(580, 334, 242, 163);
		btn_EC6.setEnabled(false);
		ImageButton(btn_EC6);
		endingcollec_panel.add(btn_EC6);
		
		lbl_et1 = new JLabel("", JLabel.CENTER);
		lbl_et1.setFont(new Font("�޸ո���T", Font.BOLD, 17));
		lbl_et1.setBounds(26, 304, 242, 30);
		endingcollec_panel.add(lbl_et1);
		
		lbl_et2 = new JLabel("", JLabel.CENTER);
		lbl_et2.setFont(new Font("�޸ո���T", Font.BOLD, 17));
		lbl_et2.setBounds(304, 304, 242, 30);
		endingcollec_panel.add(lbl_et2);
		
		lbl_et3 = new JLabel("", JLabel.CENTER);
		lbl_et3.setFont(new Font("�޸ո���T", Font.BOLD, 17));
		lbl_et3.setBounds(580, 304, 242, 30);
		endingcollec_panel.add(lbl_et3);
		
		lbl_et4 = new JLabel("", JLabel.CENTER);
		lbl_et4.setFont(new Font("�޸ո���T", Font.BOLD, 17));
		lbl_et4.setBounds(26, 498, 242, 30);
		endingcollec_panel.add(lbl_et4);
		
		lbl_et5 = new JLabel("", JLabel.CENTER);
		lbl_et5.setFont(new Font("�޸ո���T", Font.BOLD, 17));
		lbl_et5.setBounds(304, 498, 242, 30);
		endingcollec_panel.add(lbl_et5);
		
		lbl_et6 = new JLabel("", JLabel.CENTER);
		lbl_et6.setFont(new Font("�޸ո���T", Font.BOLD, 17));
		lbl_et6.setBounds(580, 498, 242, 30);
		endingcollec_panel.add(lbl_et6);
		
		//���� ��� �г�
		lbl_EndingTitle = new JLabel("", JLabel.CENTER);
		lbl_EndingTitle.setForeground(Color.WHITE);
		lbl_EndingTitle.setFont(new Font("�޸յձ�������", Font.PLAIN, 37));
		lbl_EndingTitle.setBounds(14, 50, 819, 109);
		ending_panel.add(lbl_EndingTitle);
		
		ta_Eding = new JTextArea();
		ta_Eding.setEditable(false);
		ta_Eding.setFont(new Font("����", Font.BOLD, 22));
		ta_Eding.setForeground(Color.WHITE);
		ta_Eding.setBackground(Color.BLACK);
		ta_Eding.setBounds(77, 213, 691, 231);
		ending_panel.add(ta_Eding);
		
		JButton btn_GoUM = new JButton(new ImageIcon("Image/gousermain.png"));
		btn_GoUM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(user_panel);
				user_panel.updateUI();
			}
		});
		btn_GoUM.setFont(new Font("����", Font.BOLD, 17));
		btn_GoUM.setBounds(690, 445, 118, 67);
		ImageButton(btn_GoUM);
		ending_panel.add(btn_GoUM);
		
		//���� �г�
		JLabel lbl_ChoiceTitle = new JLabel("\uB2F9\uC2E0\uC758 \uC120\uD0DD\uC740??", JLabel.CENTER);
		lbl_ChoiceTitle.setFont(new Font("�޸յձ�������", Font.PLAIN, 60));
		lbl_ChoiceTitle.setBounds(14, 111, 819, 63);
		choice_panel.add(lbl_ChoiceTitle);
		
		JButton btn_Choice1 = new JButton("");
		btn_Choice1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(ending_panel);
				ending_panel.updateUI();
				Ending(lbl_EndingTitle, ta_Eding, 0);
				btn_EC1.setEnabled(true);
				btn_EC1.setIcon(new ImageIcon("Image/ending1.png"));
				lbl_et1.setText("1. �Ļ�");
			}
		});
		btn_Choice1.setForeground(Color.black);
		btn_Choice1.setBackground(Color.WHITE);
		btn_Choice1.setFont(new Font("����", Font.BOLD, 19));
		btn_Choice1.setBounds(162, 268, 532, 63);
		btn_Choice1.setBorder(new LineBorder(Color.BLACK));
		choice_panel.add(btn_Choice1);
		
		JButton btn_Choice2 = new JButton("");
		btn_Choice2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(game_panel);
				game_panel.updateUI();
				TimeThread thread=new TimeThread();
				thread.start();
			}
		});
		btn_Choice2.setForeground(Color.black);
		btn_Choice2.setFont(new Font("����", Font.BOLD, 19));
		btn_Choice2.setBackground(Color.WHITE);
		btn_Choice2.setBounds(162, 368, 532, 63);
		btn_Choice2.setBorder(new LineBorder(Color.BLACK));
		choice_panel.add(btn_Choice2);
		
		//�ó����� �г�
		JTextArea ta_scenario = new JTextArea();
		ta_scenario.setFont(new Font("����", Font.BOLD, 20));
		ta_scenario.setForeground(new Color(255, 255, 255));
		ta_scenario.setBackground(Color.BLACK);
		ta_scenario.setBounds(100, 144, 670, 235);
		scenario_panel.add(ta_scenario);
		
		JButton btn_SceNext = new JButton(new ImageIcon("Image/next.png"));
		btn_SceNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(choice_panel);
				choice_panel.updateUI();
				Choice(btn_Choice1, btn_Choice2, 0);
			}
		});
		btn_SceNext.setBounds(706, 446, 94, 48);
		ImageButton(btn_SceNext);
		scenario_panel.add(btn_SceNext);
		
		//����� ���� �г�
		JButton btn_CloseSetting = new JButton(new ImageIcon("Image/close.png"));
		btn_CloseSetting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setting_panel.setVisible(false);
				tf_ID2.setText(ID);
			}
		});
		btn_CloseSetting.setFont(new Font("�޸յձ�������", Font.PLAIN, 16));
		ImageButton(btn_CloseSetting);
		btn_CloseSetting.setBounds(348, 12, 48, 50);
		setting_panel.add(btn_CloseSetting);
		
		JLabel lbl_SetTitle = new JLabel("\uC124\uC815", JLabel.CENTER);
		lbl_SetTitle.setForeground(Color.BLACK);
		lbl_SetTitle.setFont(new Font("�޸յձ�������", Font.PLAIN, 32));
		lbl_SetTitle.setBounds(0, 12, 396, 39);
		setting_panel.add(lbl_SetTitle);
		
		JLabel lbl_ID2 = new JLabel("\uB2C9\uB124\uC784");
		lbl_ID2.setFont(new Font("�޸յձ�������", Font.PLAIN, 18));
		lbl_ID2.setBounds(14, 10, 59, 36);
		set_panel.add(lbl_ID2);
		
		tf_ID2 = new JTextField();
		tf_ID2.setBackground(Color.WHITE);
		tf_ID2.setBounds(87, 12, 205, 37);
		set_panel.add(tf_ID2);
		tf_ID2.setColumns(10);
		
		JLabel lbl_IDTitle = new JLabel("", JLabel.CENTER);
		lbl_IDTitle.setFont(new Font("�޸յձ�������", Font.PLAIN, 62));
		lbl_IDTitle.setBounds(110, 65, 605, 80);
		user_panel.add(lbl_IDTitle);
		
		JButton btn_change = new JButton(new ImageIcon("Image/change.png"));
		btn_change.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((tf_ID2.getText().equals("")))
				{
					JOptionPane.showMessageDialog(null, "�г����� �Է��� �ּ���", "ID ��ĭ", JOptionPane.WARNING_MESSAGE);
				}
				else if(tf_ID2.getText().length()>5)
				{
					JOptionPane.showMessageDialog(null, "�г����� �ִ� 5�����Դϴ�.", "ID ���� �� ����", JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					int return_num2=JOptionPane.showConfirmDialog(null, "�г���- "+tf_ID2.getText()+"(��)�� �г����� �����մϴ�.", "Ȯ��", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(return_num2==0)
					{
						ID=tf_ID2.getText();
						lbl_IDTitle.setText(ID+"�� ����");
						tf_ID2.setText(ID);
					}
				}
			}
		});
		btn_change.setFont(new Font("�޸յձ�������", Font.PLAIN, 16));
		btn_change.setFocusPainted(false);
		btn_change.setContentAreaFilled(false);
		btn_change.setBorderPainted(false);
		btn_change.setBounds(306, 15, 63, 45);
		set_panel.add(btn_change);
		
		//����� �г�
		JButton btn_GameStart = new JButton(new ImageIcon("Image/gamestart.png"));
		btn_GameStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				getContentPane().add(scenario_panel);
				scenario_panel.updateUI();
				Scenario(ta_scenario);
				lbl_LV.setText("LV "+Integer.toString(MyLV));
				lbl_Debt.setText("��: "+Integer.toString(MyDebt));
				lbl_Money.setText("��: "+Integer.toString(MyMoney));
				lbl_EXP.setText("����ġ: "+Integer.toString(MyExp));
				lbl_ID3.setText(ID);
			}
		});
		btn_GameStart.setBounds(641, 213, 149, 69);
		user_panel.add(btn_GameStart);
		ImageButton(btn_GameStart);
		
		JButton btn_Setting = new JButton(new ImageIcon("Image/setting.png"));
		btn_Setting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setting_panel.setVisible(true);
			}
		});
		btn_Setting.setBounds(641, 348, 149, 69);
		user_panel.add(btn_Setting);
		ImageButton(btn_Setting);
		
		JButton btn_EndingCollec = new JButton(new ImageIcon("Image/endingcollec.png"));
		btn_EndingCollec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				getContentPane().add(endingcollec_panel);
				endingcollec_panel.updateUI();
			}
		});
		btn_EndingCollec.setBounds(641, 280, 149, 69);
		user_panel.add(btn_EndingCollec);
		ImageButton(btn_EndingCollec);
		
		JButton btn_umBack = new JButton(new ImageIcon("Image/gomain.png"));
		btn_umBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				getContentPane().add(main_panel);
				main_panel.updateUI();
			}
		});
		btn_umBack.setBounds(641, 416, 149, 69);
		user_panel.add(btn_umBack);
		ImageButton(btn_umBack);

		//���� ���� �г�
		JLabel lbl_ExplainTitle = new JLabel("\uAC8C\uC784 \uBC29\uBC95");
		lbl_ExplainTitle.setForeground(new Color(0, 0, 0));
		lbl_ExplainTitle.setFont(new Font("�޸յձ�������", Font.PLAIN, 33));
		lbl_ExplainTitle.setBounds(181, 12, 149, 39);
		GameExplain_panel.add(lbl_ExplainTitle);
		
		JTextArea ta_GameExplain = new JTextArea();
		ta_GameExplain.setToolTipText("");
		ta_GameExplain.setFont(new Font("���ʷҵ���", Font.BOLD, 17));
		ta_GameExplain.setEditable(false);
		ta_GameExplain.setBounds(14, 62, 464, 359);
		GameExplain_panel.add(ta_GameExplain);
		GameExplain(ta_GameExplain);
		
		//���� �г�
		JButton btn_NewStart = new JButton(new ImageIcon("Image/new_start.png"));
		btn_NewStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if((tf_ID.getText().equals("")))
				{
					JOptionPane.showMessageDialog(null, "�г����� �Է��� �ּ���", "ID ��ĭ", JOptionPane.WARNING_MESSAGE);
				}
				else if(tf_ID.getText().length()>5)
				{
					JOptionPane.showMessageDialog(null, "�г����� �ִ� 5�����Դϴ�.", "ID ���� �� ����", JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					int return_num=JOptionPane.showConfirmDialog(null, "�г���- "+tf_ID.getText()+"(��)�� ������ �����մϴ�.", "Ȯ��", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(return_num==0)
					{
						getContentPane().removeAll();
						getContentPane().add(user_panel);
						user_panel.updateUI();
						ID=tf_ID.getText();
						lbl_IDTitle.setText(ID+"�� ����");
						tf_ID2.setText(ID);
						tf_ID.setText("");
					}
				}
			}
		});
		btn_NewStart.setFont(new Font("����", Font.BOLD, 18));
		btn_NewStart.setBounds(667, 235, 141, 66);
		ImageButton(btn_NewStart);
		main_panel.add(btn_NewStart);
		
		JButton btn_ContinueStart = new JButton(new ImageIcon("Image/continue.png"));
		btn_ContinueStart.setFont(new Font("����", Font.BOLD, 18));
		btn_ContinueStart.setBounds(667, 300, 141, 66);
		ImageButton(btn_ContinueStart);
		main_panel.add(btn_ContinueStart);
		
		JButton btn_GameExit = new JButton(new ImageIcon("Image/exit.png"));
		btn_GameExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		ImageButton(btn_GameExit);
		btn_GameExit.setFont(new Font("����", Font.BOLD, 18));
		btn_GameExit.setBounds(667, 432, 141, 66);
		main_panel.add(btn_GameExit);
		
		tf_ID = new JTextField();
		tf_ID.setFont(new Font("����", Font.PLAIN, 16));
		tf_ID.setBounds(338, 425, 188, 36);
		tf_ID.setColumns(10);
		main_panel.add(tf_ID);
		
		JLabel lbl_ID = new JLabel("\uB2C9\uB124\uC784");
		lbl_ID.setFont(new Font("�޸յձ�������", Font.PLAIN, 17));
		lbl_ID.setBounds(272, 424, 57, 36);
		main_panel.add(lbl_ID);
		
		JLabel lbl_MainTitle = new JLabel("\uBE5A\uACFC \uB18D\uC7A5");
		lbl_MainTitle.setBounds(284, 45, 286, 85);
		main_panel.add(lbl_MainTitle);
		lbl_MainTitle.setFont(new Font("�޸յձ�������", Font.PLAIN, 62));
		
		btn_GameExplain = new JButton(new ImageIcon("Image/explain.png"));
		btn_GameExplain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GameExplain_panel.setVisible(true);
			}
		});
		ImageButton(btn_GameExplain);
		btn_GameExplain.setFont(new Font("����", Font.BOLD, 18));
		btn_GameExplain.setBounds(667, 366, 141, 66);
		main_panel.add(btn_GameExplain);
		
		btn_CloseExplain = new JButton(new ImageIcon("Image/close.png"));
		btn_CloseExplain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameExplain_panel.setVisible(false);
			}
		});
		btn_CloseExplain.setBounds(438, 12, 38, 50);
		ImageButton(btn_CloseExplain);
		GameExplain_panel.add(btn_CloseExplain);
	}
	
	//�̹��� ����ϴ� �г�
	class MyJPanel extends JPanel
	{
		ImageIcon icon=new ImageIcon("Image/main.jpg");
		Image img=icon.getImage();
		public void paintComponent(Graphics g)
		{
			g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
			super.paintComponents(g);
		}
	}
	//�̹��� ����ϴ� �г�
	class MyJPanel2 extends JPanel
	{
		ImageIcon icon=new ImageIcon("Image/���.png");
		Image img=icon.getImage();
		public void paintComponent(Graphics g)
		{
			g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
			super.paintComponents(g);
		}
	}
	
	//�̹��� ��ư ����
	public void ImageButton(JButton button)
	{
		button.setBorderPainted(false);//��ư�� �ܰ��� �����ش�
		button.setContentAreaFilled(false); //��ư�� ���� ���� ä��� ����
		button.setFocusPainted(false); //��ư�� ���õǾ��� �� ����� �׵θ� ��� ����
	}
	
	//���� ����
	public void GameExplain(JTextArea ta_GameExplain)
	{
		String [] ex=new String [7];
		String game_explain="";
		
		ex[0]=" ������ ���� ���� ���� ������ ��ϴ� �����Դϴ�.\n";
		ex[1]=" ������ �������� ����� ���� ������ �ϰ� �ɰ��Դϴ�.";
		ex[2]="     ����� ���ÿ� ���� ������ �ٲ�� ������ ��� ������ \n    Ư���� ������ �帳�ϴ�.\n";
		ex[3]=" �������� ��ϸ� ������ �� Ű�� ���� �Ǹ��ϰų� \n �λ깰�� �Ǹ��Ͽ� ���� ���ϴ�.\n";
		ex[4]=" ������ ���� 15�� �Ǹ� ������ �佺Ƽ���� ������ �� �ֽ��ϴ�.\n";
		ex[5]=" ������ �����ϸ��� ���ڰ� �ٽ��ϴ�. �������� 0.02%�Դϴ�.\n";
		ex[6]=" ������ ������ ���� ���࿡ ���� ��������. \n    �׷��� ������ ���� ���� �þ �ſ���!\n";
		
		game_explain=ex[0]+"\n"+ex[1]+"\n"+ex[2]+"\n"+ex[3]+"\n"+ex[4]+"\n"+ex[5]+"\n"+ex[6];
		ta_GameExplain.setText(game_explain);
	}
	
	//���� �ó�����
	public void Scenario(JTextArea textarea)
	{
		String []sce=new String[4];
		sce[0]="����� ������ ��� ��. . .";
		sce[1]="���� ���� ���� ������ ��Ͻô� �ƹ����� ���η� ���ư��̴ٴ� \n������ �޾Ҵ�. .";
		sce[2]="���� ������ ���� �� �ƹ����� ����� �� 1��. . �׸��� ���� 1����";
		sce[3]="������ ���� ������ �� �� ������. . . .";
		
		textarea.setText(sce[0]+"\n\n"+sce[1]+"\n\n"+sce[2]+"\n\n"+sce[3]);
	}
	
	//����
	public void Choice(JButton choice1, JButton choice2, int choice_type)
	{
		String cho[][]=new String[2][2];
		
		cho[0][0]="������ �Ⱦ� ���� �����Ѵ�.";
		cho[0][1]="������ ������ ��Ͽ� õõ�� ���� ���´�.";
		cho[1][0]="���� ���� ���� ���ȴ�. ������ �Ǵ�.";
		cho[1][1]="��� ������ ��Ѵ�.";
		
		choice1.setText(cho[choice_type][0]);
		choice2.setText(cho[choice_type][1]);
	}
	
	//���� ���
	public void Ending(JLabel Title, JTextArea textarea, int ending_type)
	{
		String [] title=new String [5];
		String [] ending=new String [5];
		
		title[0]="����1.�Ļ�...";
		title[1]="����2.����� ��";
		title[2]="����3.�鸸����";
		title[3]="����4.�ְ��� ���� ������";
		title[4]="����5.�ǹ���";
		
		ending[0]="������ �Ⱦ� ���� �����ߴ�. ������ ���� �� ���⿣ �����ߴ�.\n\n���� ���� �ɷµ� �ǿ嵵 ���� ���� �ᱹ �Ļ��ߴ�.\n\n������ ���� ��� ��ư����ұ�?...";
		ending[1]="\n������ �Ⱦ� ���� ��� ���Ҵ�!\n\n�� �̻� ������ � �� ���� ������ ���� ������ ����� ���� �� ���̴�.";
		ending[2]="������ ��� ���� ��� ���Ҵ�!\n\n������ ã�� ���� ������ ������ ��Ͽ��� �鸸 ���ڰ� �Ǿ���.\n\n������ �� ������ ���� ��� �︸���ڰ� �� ���̴�!";
		ending[3]="������ ��� ���� ��� ���Ҵ�!\n\n���� �佺Ƽ������ �ټ��� 1���� �� ����\n\n�� ���� ������� ã�� �ְ��� ���� �����ڰ� �Ǿ���!";
		ending[4]="������ ��� ���� ��� ���Ҵ�!\n\n���� �Ͽ� ���� ���� ���� ������ ���ְ� �ǹ��� ������.\n\n�׷��� ���� �޿� �׸��� �ǹ��ְ� �Ǿ���!!";
		
		Title.setText(title[ending_type]);
		textarea.setText(ending[ending_type]);
	}
	
	//���� ��ư ��Ȱ��ȭ
	public void Store_btnset(AnimalAddButton A1, AnimalAddButton A2, AnimalAddButton A3, AnimalAddButton A4, AnimalAddButton A5)
	{
		if(MyMoney>=150000)
		{
			A5.setEnabled(true);
			A4.setEnabled(true);
			A3.setEnabled(true);
			A2.setEnabled(true);
			A1.setEnabled(true);
		}
		if(MyMoney<150000)
		{
			A5.setEnabled(false);
			A4.setEnabled(true);
			A3.setEnabled(true);
			A2.setEnabled(true);
			A1.setEnabled(true);
		}	
		if(MyMoney<100000)
		{
			A5.setEnabled(false);
			A4.setEnabled(false);
			A3.setEnabled(true);
			A2.setEnabled(true);
			A1.setEnabled(true);
		}
		if(MyMoney<50000)
		{
			A5.setEnabled(false);
			A4.setEnabled(false);
			A3.setEnabled(false);
			A2.setEnabled(true);
			A1.setEnabled(true);
		}
		if(MyMoney<10000)
		{
			A5.setEnabled(false);
			A4.setEnabled(false);
			A3.setEnabled(false);
			A2.setEnabled(false);
			A1.setEnabled(true);	
		}
		if(MyMoney<3000)
		{
			A5.setEnabled(false);
			A4.setEnabled(false);
			A3.setEnabled(false);
			A2.setEnabled(false);
			A1.setEnabled(false);	
		}
		lbl_Money.setText("��: "+Integer.toString(MyMoney));
		lbl_Money_store.setText("��: "+Integer.toString(MyMoney));
		MyAnimalCount=MyAnimalCount+1;
	}
	
	//���� ��ư ��Ȱ��ȭ
	public void Store_btnset2(JButton F1, JButton F2, JButton F3)
	{
		if(MyMoney>=15000)
		{
			F2.setEnabled(true);
			F1.setEnabled(true);
			F3.setEnabled(true);
		}
		if(MyMoney<15000)
		{
			F2.setEnabled(false);
			F1.setEnabled(true);
			F3.setEnabled(true);
		}	
		if(MyMoney<3000)
		{
			F2.setEnabled(false);
			F3.setEnabled(false);
			F1.setEnabled(true);
		}
		if(MyMoney<500)
		{
			F1.setEnabled(false);
			F2.setEnabled(false);
			F3.setEnabled(false);
		}
		lbl_Money.setText("��: "+Integer.toString(MyMoney));
		lbl_Money_store.setText("��: "+Integer.toString(MyMoney));
	}
	
	//�� ����
	public void MyMoney(int m)
	{
		String money= m+"��";
	      
		lbl_Money.setText(money);
	}
	
	//�� ����
	public void MyDebt(int debt)
	{
		String Debt=debt+ "��";
		
		lbl_Debt.setText(Debt);
	}
	
	//���� �г� ���
	public void Helpf(JTextArea ta1, JTextArea ta2, JTextArea ta3, JTextArea ta4, JTextArea ta5, JTextArea ta6, JTextArea ta7)
	{
		ta1.setText(" �� ȹ��\n\n -���� �� �λ깰 �ȱ�� ȹ���Ͻ� �� �ֽ��ϴ�.\n\n -�ζ� ��÷ �� ����� ���� ���� �����մϴ�.\n\n -���׽�Ʈ ��� �� ����� ���� ���� �����մϴ�.\n\n -���� �ʹ� ���ϴٸ� ���࿡�� ������ ��������");
		ta2.setText(" ���� ����\n\n -�� ���� ��ư�� Ŭ���մϴ�.\n\n -�� ���� ��Ͽ��� ���ϴ� ���� Ŭ�� �� ���� ������ �� �� �ֽ��ϴ�.\n\n -�� �ֱ�, ��Ʈ �ֱ� ������ ������ �ɷ�ġ�� ü���� �����ϴ�.\n\n -ü���� 0�� �� �� ���� ���� ���� ������ ������ ������ �˴ϴ�.\n\n -�� ��� �������� ���� �����Ͽ� ���̼���");
		ta3.setText(" �ζ�\n\n -�ζǴ� �������� ���Ÿ� �� �� �ֽ��ϴ�.\n\n -6���� ���ڸ� �������� �� �� ��ư�� Ŭ���ϸ� �� ���� ��ȣ�� ���ɴϴ�.\n\n -��ġ�ϴ� ������ ������ ���� ����� �������ϴ�.\n\n -�ζǴ� �����Ͽ� �ѹ����� �����մϴ�.");
		ta4.setText(" �λ깰\n\n -�λ깰�� ������ ������ ���� �ٸ��ϴ�.\n\n -���� �ð��� ������ �λ깰�� ������ �˴ϴ�.\n\n -Ŭ���� �Ͽ� ������ �� �� �ֽ��ϴ�.\n\n -���濡�� �λ깰�� ���� ���ο� �������� ���� �� �ֽ��ϴ�.");
		ta5.setText(" ����\n\n -���� �������� ���� ������ �ϰ� �˴ϴ�.\n\n -�� ���ÿ� ���� ������ �ٲ�� �˴ϴ�. \n\n -������ ���� �����Կ��� �� �� �ֽ��ϴ�. \n\n -������ �ٽ� ���� ���� �� ��� ���� �����Կ��� ������ Ŭ���ϸ� \n  ������ �ٽ� �� �� �ֽ��ϴ�.\n\n -������ ��� ������ Ư���� ������ �帳�ϴ�.");
		ta6.setText(" ����\n\n -���࿡���� �� ����� ������ �� �� �ֽ��ϴ�.\n\n -�������� ���� �����ϸ��� ���� �þ�ϴ�.");
		ta7.setText(" ���׽�Ʈ\n\n -���� ���� 15�� �Ǹ� ���׽�Ʈ�� ������ �� �ֽ��ϴ�.\n\n -������ �ɷ�ġ�� ���� ����� �����˴ϴ�.\n\n -����� ���� ����ġ�� ����� ���� �� �ֽ��ϴ�.\n\n -���׽�Ʈ���� ����� �Ѵٸ� �� ������ �α⸦ ��� �ٸ� ������\n  ������ �˴ϴ�.\n\n -�ʹ� �ƽ������� ������. ��� ���� ����� �帳�ϴ�.");
	}
	
	//���� ����
	public void Animal_Data()
	{
		String[] pro=new String[5];
		Random n=new Random();
		int a=n.nextInt(5);
		
		pro[0]="�峭�Ⱑ ����";
		pro[1]="��Ž�� ����";
		pro[2]="������";
		pro[3]="�������� ����";
		pro[4]="������";
		
		lbl_Animal1_Property.setText(pro[a]);
	}
	
	//�λ깰 ���� ���� 
	TimerTask egg_make=new TimerTask()
	{
		public void run()
		{
			Item.egg++;
			lbl_megg.setText(Integer.toString(Item.egg));
		}
	};
	
	TimerTask degg_make=new TimerTask()
	{
		public void run()
		{
			Item.degg++;
			lbl_mdegg.setText(Integer.toString(Item.degg));
		}
	};
	TimerTask wool_make=new TimerTask()
	{
		public void run()
		{
			Item.wool++;
			lbl_mwool.setText(Integer.toString(Item.wool));
		}
	};
	TimerTask meet_make=new TimerTask()
	{
		public void run()
		{
			Item.meet++;
			lbl_mmeet.setText(Integer.toString(Item.meet));
		}
	};
	TimerTask milk_make=new TimerTask()
	{
		public void run()
		{
			Item.milk++;
			lbl_mmilk.setText(Integer.toString(Item.milk));
		}
	};
	
	//������ ���� ����
	public void Item_Data(JLabel lbl_megg,JLabel lbl_mdegg,JLabel lbl_mwool,JLabel lbl_mmeet,JLabel lbl_mmilk,
			JLabel lbl_mcheese,JLabel lbl_myarn,JLabel lbl_msausage,JLabel lbl_myogurt,JLabel lbl_mhfeed,
			JLabel lbl_mlfeed,JLabel lbl_mmedicine)
	{
		lbl_megg.setText(Item.egg+"");
		lbl_mdegg.setText(Item.degg+"");
		lbl_mwool.setText(Item.wool+"");
		lbl_mmeet.setText(Item.meet+"");
		lbl_mmilk.setText(Item.milk+"");
		lbl_mcheese.setText(Item.cheese+"");
		lbl_myarn.setText(Item.yarn+"");
		lbl_msausage.setText(Item.sausage+"");
		lbl_myogurt.setText(Item.yogurt+"");
		lbl_mhfeed.setText(Item.hfeed+"");
		lbl_mlfeed.setText(Item.lfeed+"");
		lbl_mmedicine.setText(Item.medicine+"");
	}
	
	//�ζ� ��� ���
	public void Lotto(int [] input_num)
	{
		int []num=new int[6];
		int a=0;
		int count=0;
		String text="";
        num[0] = (int)(Math.random()*45)+1;
        for(int i=1; i<6; i++)
        {
            while (true) //�ߺ� ���� �� ���� �ݺ�
            {
                num[i] = (int)(Math.random()*45)+1;
                for (int j = 0; j < i; j++)
                    if (num[i] == num[j])
                        a++;
                if (a == 0)
                    break;
                a = 0; 
            }
        }
        
        for(int i=0; i<6; i++)
        {
        	for(int j=0; j<6; j++)
        	{
        		if(input_num[i]==num[j])
    				count++;
        	}
        }
        
        text="��÷ ��ȣ: "+num[0]+", "+num[1]+", "+num[2]+", "+num[3]+", "+num[4]+", "+num[5]+"\n";
        
        if(count==6)
        {
        	text=text+"��÷!! 1���Դϴ�!!!\n���: 1000000000��";
        	MyMoney+=1000000000;
        	
        }
        else if(count==5)
        {
        	text=text+"��÷!! 2���Դϴ�!!\n���: 50000000��";
        	MyMoney+=50000000;
        }
        else if(count==4)
        {
        	text=text+"��÷!! 3���Դϴ�!!\n���: 1500000��";
        	MyMoney+=1500000;
        }
        else if(count==3)
        {
        	text=text+"��÷!! 4���Դϴ�!!\n���: 50000��";
        	MyMoney+=50000;
        }
        else if(count==2)
        {
        	text=text+"��÷!! 5���Դϴ�!!\n���: 5000��";
        	MyMoney+=5000;
        }
        else
        	text=text+"��!!\n���� ��ȸ��..";
        
        JOptionPane.showMessageDialog(null, text);
        lbl_Money.setText("��: "+MyMoney);
		lbl_Money_store.setText("��: "+MyMoney);
	}
	
	//���׽�Ʈ ���
	public void Contest_Result_cf(JLabel lbl_cs_name,JLabel lbl_ct_name,JLabel lbl_cs_image,JLabel lbl_ct_image)
	{
		String [] name=new String[7];
		Random nc=new Random();
		int ac=nc.nextInt(7);
		int ac2=nc.nextInt(7);
		ImageIcon s=new ImageIcon("Image/����.png");
		ImageIcon t=new ImageIcon("Image/��.png");
		
		name[0]="����";
		name[1]="��ȣ";
		name[2]="����";
		name[3]="����";
		name[4]="����";
		name[5]="�ٽ�";
		name[6]="����";
		
		lbl_cs_name.setText(name[ac]);
		lbl_ct_name.setText(name[ac2]);
		lbl_cs_image.setIcon(s);
		lbl_ct_image.setIcon(t);
	}
	public void Contest_Result_cs(JLabel lbl_cf_name,JLabel lbl_ct_name,JLabel lbl_cf_image,JLabel lbl_ct_image)
	{
		String [] name=new String[7];
		Random nc=new Random();
		int ac=nc.nextInt(7);
		int ac2=nc.nextInt(7);
		ImageIcon s=new ImageIcon("Image/����.png");
		ImageIcon t=new ImageIcon("Image/��.png");
		
		name[0]="����";
		name[1]="��ȣ";
		name[2]="����";
		name[3]="����";
		name[4]="����";
		name[5]="�ٽ�";
		name[6]="����";
		
		lbl_cf_name.setText(name[ac]);
		lbl_ct_name.setText(name[ac2]);
		lbl_cf_image.setIcon(s);
		lbl_ct_image.setIcon(t);
	}
	public void Contest_Result_ct(JLabel lbl_cs_name,JLabel lbl_cf_name,JLabel lbl_cs_image,JLabel lbl_cf_image)
	{
		String [] name=new String[7];
		Random nc=new Random();
		int ac=nc.nextInt(7);
		int ac2=nc.nextInt(7);
		ImageIcon s=new ImageIcon("Image/����.png");
		ImageIcon t=new ImageIcon("Image/��.png");
		
		name[0]="����";
		name[1]="��ȣ";
		name[2]="����";
		name[3]="����";
		name[4]="����";
		name[5]="�ٽ�";
		name[6]="����";
		
		lbl_cs_name.setText(name[ac]);
		lbl_cf_name.setText(name[ac2]);
		lbl_cs_image.setIcon(s);
		lbl_cf_image.setIcon(t);
	}
	public void Contest_Result_no(JLabel lbl_cs_name,JLabel lbl_cf_name,JLabel lbl_ct_name,
			JLabel lbl_cs_image,JLabel lbl_cf_image,JLabel lbl_ct_image)
	{
		String [] name=new String[7];
		Random nc=new Random();
		int ac=nc.nextInt(7);
		int ac2=nc.nextInt(7);
		int ac3=nc.nextInt(7);
		ImageIcon s=new ImageIcon("Image/����.png");
		ImageIcon t=new ImageIcon("Image/��.png");
		ImageIcon f=new ImageIcon("Image/����.png");
		
		name[0]="����";
		name[1]="��ȣ";
		name[2]="����";
		name[3]="����";
		name[4]="����";
		name[5]="�ٽ�";
		name[6]="����";
		
		lbl_cs_name.setText(name[ac]);
		lbl_cf_name.setText(name[ac2]);
		lbl_ct_name.setText(name[ac3]);
		lbl_cs_image.setIcon(s);
		lbl_cf_image.setIcon(t);
		lbl_ct_image.setIcon(f);
	}
	//�������� ���� ������ ���� �гο� ���� �߰�
	class AnimalAddButton extends JButton {
	    JPanel p;
	    int x, y=0;
	    String image_name;
	    String bimage_name;
	    ImageIcon icon;
	    ImageIcon bicon;
	    Image bimg;
	    int m=0;
		public AnimalAddButton(JPanel p, String string) 
		{
			this.p=p;
			this.setBorderPainted(false);
			this.setContentAreaFilled(false); 
			this.setFocusPainted(false); 
			
			image_name="Image/"+string+".png";
			bimage_name="Image/"+string+"_����.png";
			icon=new ImageIcon(image_name);
			bicon=new ImageIcon(bimage_name);
			
			bimg=bicon.getImage();
	        addMouseListener(new MouseAdapter() {
	          public void mousePressed(MouseEvent e) {
	        	  if(string.equals("��"))
	        		  m=3000;
	        	  else if(string.equals("����"))
	        		  m=10000;
	        	  else if(string.equals("��"))
	        		  m=50000;
	        	  else if(string.equals("����"))
	        		  m=100000;
	        	  else if(string.equals("����"))
	        		  m=150000;
	        	  if(MyMoney<m)
	        	  {
	        		  JOptionPane.showMessageDialog(null, "���� �����մϴ�.", "�� ����", JOptionPane.WARNING_MESSAGE);
	        	  }
	        	  else
	        	  {
	        		  if(count<10)
						{
							int return_num5=JOptionPane.showConfirmDialog(null, string+"�� ���� �Ͻðڽ��ϱ�?", "Ȯ��", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
							if(return_num5==0)
							{
								x=(int)(Math.random()*750)+30;
					      		 y=(int)(Math.random()*330)+30;
					             AnimalThread animalThread = new AnimalThread(x, y,icon);
					             animalThread.start();
					             if(string.equals("��"))
					             {
					            	 MyMoney=MyMoney-3000;
					            	 timer1=new Timer();
					 				 timer1.schedule(egg_make, 5000, 90000);
					             } 
					             
					             else if(string.equals("����"))
					             {
					            	 MyMoney=MyMoney-10000;
					            	 timer2=new Timer();
					            	 timer2.schedule(degg_make, 5000, 180000);
					            	
					             }	
					             else if(string.equals("��"))
					             {
					            	 MyMoney=MyMoney-50000;
					            	 timer3=new Timer();
					            	 timer3.schedule(wool_make, 5000, 270000);
					            	 
					             }
					             else if(string.equals("����"))
					             {
					            	 MyMoney=MyMoney-100000;
					            	 timer4=new Timer();
					            	 timer4.schedule(meet_make, 5000, 360000);
					            	
					             }				            	
					             else if(string.equals("����"))
					             {
					            	 MyMoney=MyMoney-150000;
					            	 timer5=new Timer();
					            	 timer5.schedule(milk_make, 5000, 450000);
					            	 
					             }			           	 
					             Store_btnset(btn_A1, btn_A2, btn_A3, btn_A4, btn_A5);
					             Store_btnset2(btn_F1, btn_F2, btn_F3);
					             
								String animal_name = JOptionPane.showInputDialog("�̸��� �Է��� �ּ���.");
								Animal[count].a_name=animal_name;
								Animal_Data();
								Animal[count].a_property=lbl_Animal1_Property.getText();
								Animal[count].a_image=icon;
								Animal[count].a_avility=0;
								Animal[count].a_hp=10;
								Animal[count].a_species=string;
								btn_CO[count].setIcon(icon);
								btn_CO[count].setText(Animal[count].a_name);
								btn_MA[count].setIcon(icon);
								btn_MA[count].setText(Animal[count].a_name);
								count++;
								MyExp+=10;
								lbl_EXP.setText("����ġ "+MyExp);
								Store_btnset(btn_A1, btn_A2, btn_A3, btn_A4, btn_A5);
								Store_btnset2(btn_F1, btn_F2, btn_F3);
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null, "������ 10�������� Ű��Ǽ� �ֽ��ϴ�!", "���� �� �ִ�", JOptionPane.WARNING_MESSAGE);
						}	
	        	  }
	          }
	       });
	        
	    	
	    }
	    
		public void paintComponent(Graphics g)
		{
			g.drawImage(bimg, 0, 0, getWidth(), getHeight(), null);
			super.paintComponents(g);
		}
		
	    class AnimalThread extends Thread {//�̹���������
	       JButton animal;
	       int choice=0;
	       int x1, x2, y1, y2, c=0;
	       public AnimalThread(int x, int y, ImageIcon img) {
	          
	          animal = new JButton(img);
	          animal.setSize(img.getIconWidth(),img.getIconHeight());
	          animal.setBorderPainted(false);//��ư�� �ܰ��� �����ش�
	          animal.setContentAreaFilled(false); //��ư�� ���� ���� ä��� ����
	          animal.setFocusPainted(false); //��ư�� ���õǾ��� �� ����� �׵θ� ��� ����
	          animal.setLocation(x, y);
	          animal.addMouseListener(new MouseAdapter() {
	              public void mousePressed(MouseEvent e) {
	            	  JOptionPane.showMessageDialog(null, "���Ƚ��ϴ�.", "test", JOptionPane.WARNING_MESSAGE);
	              }
	           });
	          p.add(animal); 
	          repaint();
	       }
	       
	       public void run() { //�¿�� ������
	          while(true) {
	        	 
	        	 int x=0, y=0;
	        	 if(choice==0)
	        	 {
	        		 x = animal.getX()+5;
	        		 choice=1;
	        		 repaint();
	        		 
	        	 }
	        	 else
	        	 {
	        		x = animal.getX()-5;
	        		 choice=0;
	        		 repaint();
	        		
	        	 }
	        	 y=animal.getY();
	              animal.setLocation(x, y);
	              //repaint();
	              try {
	                 sleep(200);
	              }
	              catch(InterruptedException e){}
	          }
	       }
	    }
	}
}

