import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.*;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;


public class SalesManage {
	
	private String[] yearData = {"2018","2019","2020"};
	private String[] monthData = {"1","2","3","4","5","6","7","8","9","10","11","12"};
	
	private JFrame frame = new JFrame();
	
	MyCalendarModel model = new MyCalendarModel();
	JTable cal = new JTable(model);
	
	private int year_, month_;
	
	public SalesManage() {
		
		frame.setBounds(100, 100, 600, 600);
		frame.setTitle("매출 관리");
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		
		JPanel selectJp = new JPanel(new GridLayout(1,2));
		selectJp.setBorder(BorderFactory.createEmptyBorder(50, 30, 0, 200));
		JPanel calendarJp = new JPanel();
		JPanel salesJp = new JPanel(new GridLayout(1,2));
		salesJp.setBorder(BorderFactory.createEmptyBorder(0, 30, 50, 50));
		
		JComboBox<String> year = new JComboBox<String>(yearData);
		year.setSize(62,35);
		year.setSelectedIndex(2);
		selectJp.add(year);
		
		Calendar c = Calendar.getInstance();
		JComboBox<String> month = new JComboBox<String>(monthData);
		month.setSize(62,35);
		month.setSelectedIndex(c.get(Calendar.MONTH));
		selectJp.add(month);
		
		JLabel daySales = new JLabel("일 매출 : " +  "50000원");
		daySales.setFont(new Font("굴림", Font.BOLD, 22));
		daySales.setSize(50,50);
		salesJp.add(daySales);
		
		JLabel totalSales = new JLabel("월 총매출 : " + "700000원");
		totalSales.setFont(new Font("굴림", Font.BOLD, 22));
		totalSales.setSize(50,50);
		salesJp.add(totalSales);	
		
		calendarJp.add(cal);
		year_ = year.getSelectedIndex()+2018;
		month_= month.getSelectedIndex()+1;
		
		model.setMonth(year.getSelectedIndex()+2018, month.getSelectedIndex());

		cal.setShowGrid(true);
		cal.setGridColor(Color.DARK_GRAY);
		cal.setSize(600, 600);
		cal.setRowHeight(60);
		cal.setRowHeight(0, 30);
		cal.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cal.setCellSelectionEnabled(true);
		cal.setSelectionBackground(Color.gray);
		
		frame.add(selectJp, BorderLayout.NORTH);
		frame.add(calendarJp, BorderLayout.CENTER);
		frame.add(salesJp, BorderLayout.SOUTH);
		frame.setVisible(true);
		
		year.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				model.setMonth(year.getSelectedIndex()+2018, month.getSelectedIndex());
				year_ = year.getSelectedIndex()+2018;
				cal.repaint();
				
			}
		});
		
		month.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				model.setMonth(year.getSelectedIndex()+2018, month.getSelectedIndex());
				month_= month.getSelectedIndex()+1;
				cal.repaint();
			}
		});
		
		cal.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {
				int row = cal.getSelectedRow();
				int col = cal.getSelectedColumn();
				
				Object data = model.getValueAt(row, col);
				
				System.out.println(year_ + "년 " + month_ + "월 " + data + "일");
			}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}		
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		
		frame.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {}
			@Override
			public void windowIconified(WindowEvent e) {}
			@Override
			public void windowDeiconified(WindowEvent e) {}
			@Override
			public void windowDeactivated(WindowEvent e) {}
			
			@Override
			public void windowClosing(WindowEvent e) { new Menu(); }
			
			@Override
			public void windowClosed(WindowEvent e) {}
			@Override
			public void windowActivated(WindowEvent e) {}
		});
	}

	// table 모델 class
	class MyCalendarModel extends AbstractTableModel {

		String[] days = { "일", "월", "화", "수", "목", "금", "토" };

		int[] lastDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		
		// 날짜 들어가는 배열
		String[][] calendar = new String[7][7];

		// 초기화
		public MyCalendarModel() {
			// header
			for (int i = 0; i < days.length; ++i) {
				calendar[0][i] = days[i];
			}
			for (int i = 1; i < 7; ++i) {
				for (int j = 0; j < 7; ++j) {
					calendar[i][j] = null;
				}
			}
		}

		@Override
		public int getColumnCount() {
			return 7;
		}

		@Override
		public int getRowCount() {
			return 7;
		}

		@Override
		public Object getValueAt(int row, int column) {
			return calendar[row][column];
		}

		@Override
		public void setValueAt(Object value, int row, int column) {
			calendar[row][column] = (String) value;
		}

		// 달마다 날짜 설정
		public void setMonth(int year, int month) {
			for (int i = 1; i < 7; ++i) {
				for (int j = 0; j < 7; ++j) {
					calendar[i][j] = null;
				}
			}

			GregorianCalendar cal = new GregorianCalendar();
			cal.set(year, month, 1);

			int offset = cal.get(GregorianCalendar.DAY_OF_WEEK) - 1;
			offset += 7;
			
			// 달 마지막 날짜
			int num = daysInMonth(year, month);
			for (int i = 0; i < num; ++i) {
				calendar[offset / 7][offset % 7] = Integer.toString(i + 1);
				++offset;
			}
		}

		// 윤년
		public boolean isLeapYear(int year) {
			if (year % 4 == 0)
				return true;

			return false;
		}

		public int daysInMonth(int year, int month) {
			int days = lastDays[month];
			if (month == 1 && isLeapYear(year)) {
				++days;
			}

			return days;
		}

	}

	public static void main(String[] args) {
		new SalesManage();
	}

}
