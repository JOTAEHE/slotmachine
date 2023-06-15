package selfproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Slot extends JFrame {

	public static void main(String[] args) {
		
		Font font = new Font("모노", Font.ITALIC, 30);
		Font font2 = new Font("일반", Font.BOLD, 20);
		Font font3 = new Font("숫자", Font.PLAIN, 40);
		JPanel pan1 = new JPanel();
		JFrame frm = new JFrame("슬 롯 머 신");
		frm.setSize(640, 480);
		// 프레임을 화면 가운데에 배치
		frm.setLocationRelativeTo(null);
		// 프레임을 닫았을 때 메모리에서 제거되도록 설정
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // a
		// 레이아웃 설정
		frm.getContentPane().setLayout(null);

		// 컨텐츠 영역의 크기 표시
		System.out.println(frm.getContentPane().getSize());
		// 버튼 생성
		JButton btn1 = new JButton("슬롯 머신 래버");
		JButton btn2 = new JButton("배 팅");
		// 버튼 위치와 크기 설정
		btn1.setBounds(180, 360, 122, 30);
		btn2.setBounds(332, 360, 122, 30);
		// 프레임에다가 버튼 추가
		frm.getContentPane().add(btn1);
		frm.getContentPane().add(btn2);

		// 라벨 설정
		JLabel lb = new JLabel();
		lb.setBounds(170, 250, 274, 50);
		lb.setFont(font);
		//수평 정렬
		lb.setHorizontalAlignment(JLabel.CENTER);
		lb.setText("게임을 시작합니다");
		frm.getContentPane().add(lb);

		// 보유코인라벨 설정
		JLabel lbcoin = new JLabel();
		lbcoin.setBounds(100, 30, 122, 30);
		lbcoin.setFont(font2);
		lbcoin.setText("보유 코인 : ");
		frm.getContentPane().add(lbcoin);

		// 보유코인 숫자 라벨 설정
		JLabel lbCoinNum = new JLabel();
		lbCoinNum.setBounds(210, 30, 122, 30);
		lbCoinNum.setFont(font2);
		lbCoinNum.setText("100");
		frm.getContentPane().add(lbCoinNum);

		// 배팅 코인 라벨 설정
		JLabel batCoin = new JLabel();
		batCoin.setBounds(380, 30, 122, 30);
		batCoin.setFont(font2);
		batCoin.setText("배팅 코인 : ");
		frm.getContentPane().add(batCoin);

		// 배팅 코인 숫자 라벨 설정
		JLabel batCoinNum = new JLabel();
		batCoinNum.setBounds(490, 30, 122, 30);
		batCoinNum.setFont(font2);
		batCoinNum.setText("0");
		frm.getContentPane().add(batCoinNum);

		// 첫번째 숫자 세팅
		JLabel num = new JLabel();
		num.setBounds(100, 150, 122, 30);
		num.setFont(font3);
		num.setForeground(Color.magenta);
		num.setText("0");
		frm.getContentPane().add(num);
		// 두번째 슬롯 숫자 세팅
		JLabel num2 = new JLabel();
		num2.setBounds(300, 150, 122, 30);
		num2.setFont(font3);
		num2.setForeground(Color.BLUE);
		num2.setText("0");
		frm.getContentPane().add(num2);
		// 세번째 슬롯 숫자 세팅
		JLabel num3 = new JLabel();
		num3.setBounds(500, 150, 122, 30);
		num3.setFont(font3);
		num3.setForeground(Color.RED);
		num3.setText("0");
		frm.getContentPane().add(num3);

		// 프레임이 보이도록 설정
		frm.setVisible(true);
		//프레임 조절불가능
		frm.setResizable(false);
		
		// btn2 배팅 버튼의 기능
		btn2.addActionListener(new ActionListener() { 

			@Override
			public void actionPerformed(ActionEvent e) {

				// 배팅 입력 다이얼로그 설정
				String batting;
				// 배팅 코인 숫자
				int i; 
				// 보유코인 숫자 라벨의 텍스트를 가져와서 인트로 변환해줌
				int j = Integer.parseInt(lbCoinNum.getText()); 
				// 취소 할경우 뜨는 에러를 예외처리
				try { 
					// 반복문을 통해 배팅 숫자값이 100이 넘어갈경우 반복 시행함
					do { 
						batting = JOptionPane.showInputDialog("배팅 금액 입력"); // 배팅 버튼 누를시 팝업
						i = Integer.parseInt(batting); // 문자열값 배팅을 숫자형으로 변경
						if (i > j) {
							System.out.println("배팅한 코인이 보유한 코인보다 많습니다.");
						} // 배팅한 코인이 보유코인을 넘어갈경우에만
					} while (i > j);
					batCoinNum.setText(batting); // 배팅코인 텍스트에 배팅 코인 값을 입력

				} catch (Exception e2) { // 예외처리 후 문장 출력
					System.out.println("취소 하였습니다.");
				}
			}
		});
		// btn1 슬롯머신 래버 버튼의 기능
		btn1.addActionListener(new ActionListener() { 

			@Override
			public void actionPerformed(ActionEvent e) {

				String[] symbols = { "1", "2", "3", "4", "5" }; // 슬롯머신 내용물
				String[] symbols2 = { "1", "2", "3", "4", "5" }; // 슬롯머신 내용물
				String[] symbols3 = { "1", "2", "3", "4", "5" }; // 슬롯머신 내용물

				List<String> list = Arrays.asList(symbols);
				List<String> list2 = Arrays.asList(symbols2);
				List<String> list3 = Arrays.asList(symbols3);

				// 슬롯머신 내용물 섞고돌리고 섞고
				Collections.shuffle(list);
				list.toArray(symbols);

				Collections.shuffle(list2);
				list2.toArray(symbols2);

				Collections.shuffle(list3);
				list3.toArray(symbols3);

				// 위에 선언해둔 슬롯머신의 위치 및 판넬등을 불러와 내용물 랜덤픽의 첫번째를 세팅
				num.setText(list.get(0));
				num2.setText(list2.get(0));
				num3.setText(list3.get(0));

				// 슬롯머신 같은 수에 따라 변화
				int i;
				i = Integer.parseInt(batCoinNum.getText()); // 배팅한 코인을 int로
				int j;
				j = Integer.parseInt(lbCoinNum.getText()); // 기존 가지고있는 코인 int로

				if (list.get(0) == list2.get(0) && list2.get(0) == list3.get(0)) {
					lb.setText("30배 획득"); // 숫자 3개 일치
					int win30 = i * 30;
					j += win30;
				} else if (list.get(0) == list2.get(0) || list2.get(0) == list3.get(0) || list3.get(0) == list.get(0)) {
					lb.setText("3배 획득"); // 숫자 2개 일치
					int win3 = i * 3;
					j += win3;
				} else {
					j -= i; // 다다를시
					lb.setText("잃었습니다.");
				}
				if (j == 0) {
					lbCoinNum.setText(String.valueOf(j));
					JOptionPane.showMessageDialog(null, "보유한 코인이 없습니다. 종료합니다.", "보유 코인 없음",
							JOptionPane.ERROR_MESSAGE);
					// 보유 코인 바닥시 강제종료
					System.exit(0); 
				}
				lbCoinNum.setText(String.valueOf(j));
				System.out.println(list.get(0) + " " + list2.get(0) + " " + list3.get(0));
			}

			private JOptionPane showMessageDialog(Object object, String string, int errorMessage) {
				return null;
			}
		});

//        Scanner scanner = new Scanner(System.in);
//        Random random = new Random();
//
//        String[] symbols = {"체리", "레몬", "벨", "Gold", "7"};
//        int credit = 100;
//
//        while (credit > 0) {
//            System.out.println("보유하고 있는 크레딧 : " + credit + " credit");
//            System.out.print("배팅할 크레딧을 입력하세요. : ");
//            int bet = scanner.nextInt();
//
//            if (bet > credit) {
//                System.out.println("보유하고 있는 크레딧보다 많습니다. 다시 입력하세요.");
//                continue;
//            }
//
//            int symbol1 = random.nextInt(symbols.length);
//            int symbol2 = random.nextInt(symbols.length);
//            int symbol3 = random.nextInt(symbols.length);
//
//            System.out.println("슬롯머신 작동중 ... ");
//            System.out.println(symbols[symbol1] + " " + symbols[symbol2] + " " + symbols[symbol3]);
//
//            if (symbol1 == symbol2 && symbol2 == symbol3) {
//                int win = bet * 10;
//                credit += win;
//                System.out.println("3개 맞춤 대박 이겼다. " + win + " 크레딧 획득.");
//            } else if (symbol1 == symbol2 || symbol2 == symbol3 || symbol3 == symbol1 ) {
//               int win = bet * 3;
//               credit += win;
//               System.out.println("2개맞춤 이겼다. " + win + " 크레딧 획득.");
//            } else {
//               
//                credit -= bet;
//                System.out.println("와 이걸 못먹네 배팅금 " + bet + " 이나 날라감 ㅋㅋ ");
//            }
//        }
//
//        System.out.println("돈이없네 가셈 GameOver");
	}
}