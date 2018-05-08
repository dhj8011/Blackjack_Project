package com.example.scitmaster.blackjack_project;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by SCITMASTER on 2018-03-02.
 */

public class Blackjack extends AppCompatActivity {

    Button dcard1, dcard2, pcard1, pcard2, stay, surrender;
    ArrayList<Carddeck>cardList;
    int i;
    int cardCount=0;
    int playerCardResult;
    int dealerCardResult;
    int playerCard1, playerCard2, dealerCard1, dealerCard2;
    int onclickcount;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table);
        dcard1=findViewById(R.id.dcard1);
        dcard2=findViewById(R.id.dcard2);
        pcard1=findViewById(R.id.pcard1);
        pcard2=findViewById(R.id.pcard2);
        stay=findViewById(R.id.stay);
        surrender=findViewById(R.id.surrender);
        cardList=new ArrayList<>();
        onclickcount=0;

        cardList.add(new Carddeck("spade", "A"));
        cardList.add(new Carddeck("spade", "2"));
        cardList.add(new Carddeck("spade", "3"));
        cardList.add(new Carddeck("spade", "4"));
        cardList.add(new Carddeck("spade", "5"));
        cardList.add(new Carddeck("spade", "6"));
        cardList.add(new Carddeck("spade", "7"));
        cardList.add(new Carddeck("spade", "8"));
        cardList.add(new Carddeck("spade", "9"));
        cardList.add(new Carddeck("spade", "10"));
        cardList.add(new Carddeck("spade", "J"));
        cardList.add(new Carddeck("spade", "Q"));
        cardList.add(new Carddeck("spade", "K")); //스페이드 부분


        cardList.add(new Carddeck("Heart", "A"));
        cardList.add(new Carddeck("Heart", "2"));
        cardList.add(new Carddeck("Heart", "3"));
        cardList.add(new Carddeck("Heart", "4"));
        cardList.add(new Carddeck("Heart", "5"));
        cardList.add(new Carddeck("Heart", "6"));
        cardList.add(new Carddeck("Heart", "7"));
        cardList.add(new Carddeck("Heart", "8"));
        cardList.add(new Carddeck("Heart", "9"));
        cardList.add(new Carddeck("Heart", "10"));
        cardList.add(new Carddeck("Heart", "J"));
        cardList.add(new Carddeck("Heart", "Q"));
        cardList.add(new Carddeck("Heart", "K")); //하트 부분


        cardList.add(new Carddeck("Diamond", "A"));
        cardList.add(new Carddeck("Diamond", "2"));
        cardList.add(new Carddeck("Diamond", "3"));
        cardList.add(new Carddeck("Diamond", "4"));
        cardList.add(new Carddeck("Diamond", "5"));
        cardList.add(new Carddeck("Diamond", "6"));
        cardList.add(new Carddeck("Diamond", "7"));
        cardList.add(new Carddeck("Diamond", "8"));
        cardList.add(new Carddeck("Diamond", "9"));
        cardList.add(new Carddeck("Diamond", "10"));
        cardList.add(new Carddeck("Diamond", "J"));
        cardList.add(new Carddeck("Diamond", "Q"));
        cardList.add(new Carddeck("Diamond", "K")); //다이아몬드 부분


        cardList.add(new Carddeck("Club", "A"));
        cardList.add(new Carddeck("Club", "2"));
        cardList.add(new Carddeck("Club", "3"));
        cardList.add(new Carddeck("Club", "4"));
        cardList.add(new Carddeck("Club", "5"));
        cardList.add(new Carddeck("Club", "6"));
        cardList.add(new Carddeck("Club", "7"));
        cardList.add(new Carddeck("Club", "8"));
        cardList.add(new Carddeck("Club", "9"));
        cardList.add(new Carddeck("Club", "10"));
        cardList.add(new Carddeck("Club", "J"));
        cardList.add(new Carddeck("Club", "Q"));
        cardList.add(new Carddeck("Club", "K")); //클럽 부분

    }

    public void resultCulculator(int playerCard1, int playerCard2, int dealerCard1, int dealerCard2){ //카드 넘버의 합계를 통해 승패를 결정한다.


        playerCardResult=playerCard1+playerCard2;
        dealerCardResult=dealerCard1+dealerCard2;

        if(playerCardResult>dealerCardResult){
            if(playerCardResult>21){
                Toast.makeText(this,"버스트. 딜러의 승리입니다.",Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(this,"플레이어의 승리입니다.",Toast.LENGTH_SHORT).show();
        }else if(playerCardResult<dealerCardResult){
            if(dealerCardResult>21){
                Toast.makeText(this,"버스트. 플레이어의 승리입니다.",Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(this,"딜러의 승리입니다.",Toast.LENGTH_SHORT).show();
        }else if(playerCardResult==dealerCardResult){
            Toast.makeText(this,"비겼습니다.",Toast.LENGTH_SHORT).show();
        }
    }

    public void decideAce(){ //에이스 카드가 나왔을 시 팝업 메뉴 선택을 통해 에이스 카드의 넘버를 설정할 수 있다.
        if(cardList.get(i).getNum().equals("A")){
            PopupMenu popup=new PopupMenu(getApplicationContext(), pcard1);
            PopupMenu popup2=new PopupMenu(getApplicationContext(), pcard2);

            getMenuInflater().inflate(R.menu.selectacenum,popup.getMenu());
            getMenuInflater().inflate(R.menu.selectacenum,popup2.getMenu());
            popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    switch(menuItem.getItemId()){

                        case R.id.eleven :
                            playerCard1=11;
                            break;
                        case R.id.one :
                            playerCard1=1;
                            break;
                    }
                        return false;
                }
            });
            popup.show();

            popup2.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    switch (menuItem.getItemId()){
                        case R.id.eleven :
                            playerCard2=11;
                            break;
                        case R.id.one :
                            playerCard2=1;
                            break;
                    }
                    return false;
                }
            });
            popup.show();
        }
    }

    public void dealerCardset() { //게임이 종료될 시 딜러 카드를 세팅한다.

        for (int i = cardCount-1; i < cardCount + 2; i++) {

            if (cardList.get(i).getShape().equals("spade")) {
                dcard1.setText("♠" + cardList.get(i).getNum());
                dcard1.setTextColor(Color.BLACK);
                dcard1.setTextSize(30);
                try {
                    dealerCard1 = Integer.parseInt(cardList.get(i).getNum());
                } catch (NumberFormatException e) {
                    if (cardList.get(i).getNum().equals("J")) { dealerCard1 = 10;}
                    if (cardList.get(i).getNum().equals("Q")) { dealerCard1 = 10;}
                    if (cardList.get(i).getNum().equals("K")) { dealerCard1 = 10;}
                    if (cardList.get(i).getNum().equals("A")) { dealerCard1 = 11;}
                }
            }

            Collections.shuffle(cardList);
            if (cardList.get(i).getShape().equals("spade")) {
                dcard2.setText("♠" + cardList.get(i).getNum());
                dcard2.setTextColor(Color.BLACK);
                dcard2.setTextSize(30);
                try {
                    dealerCard2 = Integer.parseInt(cardList.get(i).getNum());
                } catch (NumberFormatException e) {
                    if (cardList.get(i).getNum().equals("J")) { dealerCard2 = 10;}
                    if (cardList.get(i).getNum().equals("Q")) { dealerCard2 = 10;}
                    if (cardList.get(i).getNum().equals("K")) { dealerCard2 = 10;}
                    if (cardList.get(i).getNum().equals("A")) { dealerCard2 = 11;}
                }
            }
            if (cardList.get(i).getShape().equals("Heart")) {
                dcard1.setText("♥" + cardList.get(i).getNum());
                dcard1.setTextColor(Color.RED);
                dcard1.setTextSize(30);
                try {
                    dealerCard1 = Integer.parseInt(cardList.get(i).getNum());
                } catch (NumberFormatException e) {
                    if (cardList.get(i).getNum().equals("J")) { dealerCard1 = 10;}
                    if (cardList.get(i).getNum().equals("Q")) { dealerCard1 = 10;}
                    if (cardList.get(i).getNum().equals("K")) { dealerCard1 = 10;}
                    if (cardList.get(i).getNum().equals("A")) { dealerCard1 = 11;}
                }
            }
            Collections.shuffle(cardList);
            if (cardList.get(i).getShape().equals("Heart")) {
                dcard2.setText("♥" + cardList.get(i).getNum());
                dcard2.setTextColor(Color.RED);
                dcard2.setTextSize(30);
                try {
                    dealerCard2 = Integer.parseInt(cardList.get(i).getNum());
                } catch (NumberFormatException e) {
                    if (cardList.get(i).getNum().equals("J")) { dealerCard2 = 10;}
                    if (cardList.get(i).getNum().equals("Q")) { dealerCard2 = 10;}
                    if (cardList.get(i).getNum().equals("K")) { dealerCard2 = 10;}
                    if (cardList.get(i).getNum().equals("A")) { dealerCard2 = 11;}
                }
            }
            if (cardList.get(i).getShape().equals("Diamond")) {
                dcard1.setText("◆" + cardList.get(i).getNum());
                dcard1.setTextColor(Color.RED);
                dcard1.setTextSize(30);
                try {
                    dealerCard1 = Integer.parseInt(cardList.get(i).getNum());
                } catch (NumberFormatException e) {
                    if (cardList.get(i).getNum().equals("J")) { dealerCard1 = 10;}
                    if (cardList.get(i).getNum().equals("Q")) { dealerCard1 = 10;}
                    if (cardList.get(i).getNum().equals("K")) { dealerCard1 = 10;}
                    if (cardList.get(i).getNum().equals("A")) { dealerCard1 = 11;}
                }
            }
            Collections.shuffle(cardList);
            if (cardList.get(i).getShape().equals("Diamond")) {
                dcard2.setText("◆" + cardList.get(i).getNum());
                dcard2.setTextColor(Color.RED);
                dcard2.setTextSize(30);
                try {
                    dealerCard2 = Integer.parseInt(cardList.get(i).getNum());
                } catch (NumberFormatException e) {
                    if (cardList.get(i).getNum().equals("J")) { dealerCard2 = 10;}
                    if (cardList.get(i).getNum().equals("Q")) { dealerCard2 = 10;}
                    if (cardList.get(i).getNum().equals("K")) { dealerCard2 = 10;}
                    if (cardList.get(i).getNum().equals("A")) { dealerCard2 = 11;}
                }

            }
            if (cardList.get(i).getShape().equals("Club")) {
                dcard1.setText("♣" + cardList.get(i).getNum());
                dcard1.setTextColor(Color.BLACK);
                dcard1.setTextSize(30);
                try {
                    dealerCard1 = Integer.parseInt(cardList.get(i).getNum());
                } catch (NumberFormatException e) {
                    if (cardList.get(i).getNum().equals("J")) { dealerCard1 = 10;}
                    if (cardList.get(i).getNum().equals("Q")) { dealerCard1 = 10;}
                    if (cardList.get(i).getNum().equals("K")) { dealerCard1 = 10;}
                    if (cardList.get(i).getNum().equals("A")) { dealerCard1 = 11;}
                }
            }
            Collections.shuffle(cardList);
            if (cardList.get(i).getShape().equals("Club")) {
                dcard2.setText("♣" + cardList.get(i).getNum());
                dcard2.setTextColor(Color.BLACK);
                dcard2.setTextSize(30);
                try {
                    dealerCard2 = Integer.parseInt(cardList.get(i).getNum());
                } catch (NumberFormatException e) {
                    if (cardList.get(i).getNum().equals("J")) { dealerCard2 = 10;}
                    if (cardList.get(i).getNum().equals("Q")) { dealerCard2 = 10;}
                    if (cardList.get(i).getNum().equals("K")) { dealerCard2 = 10;}
                    if (cardList.get(i).getNum().equals("A")) { dealerCard2 = 11;}
                }
            }
        }
    }

    public void playerCardset(View view) { //뒷면으로 되어 있는 플레이어 카드를 선택할 시 카드 모양과 넘버를 설정한다.

        if(onclickcount<3) { //카드를 선택한 카운터 값이 2를 넘어갈 수 없다. 한번 선택할 시 카드가 고정된다.
            if (view.getId() == R.id.pcard1) {
                if (cardList.get(i).getShape().equals("spade")) {
                    pcard1.setText("♠" + cardList.get(i).getNum());
                    pcard1.setTextColor(Color.BLACK);
                    pcard1.setTextSize(30);
                    try {
                        playerCard1 = Integer.parseInt(cardList.get(i).getNum());
                    } catch (NumberFormatException e) {
                        if (cardList.get(i).getNum().equals("J")) {
                            playerCard1 = 10;
                        }
                        if (cardList.get(i).getNum().equals("Q")) {
                            playerCard1 = 10;
                        }
                        if (cardList.get(i).getNum().equals("K")) {
                            playerCard1 = 10;
                        }
                        if (cardList.get(i).getNum().equals("A")) {
                           decideAce();
                        }
                    }
                }
                if (cardList.get(i).getShape().equals("Heart")) {
                    pcard1.setText("♥" + cardList.get(i).getNum());
                    pcard1.setTextColor(Color.RED);
                    pcard1.setTextSize(30);
                    try {
                        playerCard1 = Integer.parseInt(cardList.get(i).getNum());
                    } catch (NumberFormatException e) {
                        if (cardList.get(i).getNum().equals("J")) {
                            playerCard1 = 10;
                        }
                        if (cardList.get(i).getNum().equals("Q")) {
                            playerCard1 = 10;
                        }
                        if (cardList.get(i).getNum().equals("K")) {
                            playerCard1 = 10;
                        }
                        if (cardList.get(i).getNum().equals("A")) {
                            decideAce();
                        }
                    }
                }
                if (cardList.get(i).getShape().equals("Diamond")) {
                    pcard1.setText("◆" + cardList.get(i).getNum());
                    pcard1.setTextColor(Color.RED);
                    pcard1.setTextSize(30);
                    try {
                        playerCard1 = Integer.parseInt(cardList.get(i).getNum());
                    } catch (NumberFormatException e) {
                        if (cardList.get(i).getNum().equals("J")) {
                            playerCard1 = 10;
                        }
                        if (cardList.get(i).getNum().equals("Q")) {
                            playerCard1 = 10;
                        }
                        if (cardList.get(i).getNum().equals("K")) {
                            playerCard1 = 10;
                        }
                        if (cardList.get(i).getNum().equals("A")) {
                            decideAce();
                        }
                    }
                }
                if (cardList.get(i).getShape().equals("Club")) {
                    pcard1.setText("♣" + cardList.get(i).getNum());
                    pcard1.setTextColor(Color.BLACK);
                    pcard1.setTextSize(30);
                    try {
                        playerCard1 = Integer.parseInt(cardList.get(i).getNum());
                    } catch (NumberFormatException e) {
                        if (cardList.get(i).getNum().equals("J")) {
                            playerCard1 = 10;
                        }
                        if (cardList.get(i).getNum().equals("Q")) {
                            playerCard1 = 10;
                        }
                        if (cardList.get(i).getNum().equals("K")) {
                            playerCard1 = 10;
                        }
                        if (cardList.get(i).getNum().equals("A")) {
                            decideAce();
                        }
                    }
                }
            }
            if (view.getId() == R.id.pcard2) {
                if (cardList.get(i).getShape().equals("spade")) {
                    pcard2.setText("♠" + cardList.get(i).getNum());
                    pcard2.setTextColor(Color.BLACK);
                    pcard2.setTextSize(30);
                    try {
                        playerCard2 = Integer.parseInt(cardList.get(i).getNum());
                    } catch (NumberFormatException e) {
                        if (cardList.get(i).getNum().equals("J")) {
                            playerCard2 = 10;
                        }
                        if (cardList.get(i).getNum().equals("Q")) {
                            playerCard2 = 10;
                        }
                        if (cardList.get(i).getNum().equals("K")) {
                            playerCard2 = 10;
                        }
                        if (cardList.get(i).getNum().equals("A")) {
                            decideAce();
                        }
                    }
                }
                if (cardList.get(i).getShape().equals("Heart")) {
                    pcard2.setText("♥" + cardList.get(i).getNum());
                    pcard2.setTextColor(Color.RED);
                    pcard2.setTextSize(30);
                    try {
                        playerCard2 = Integer.parseInt(cardList.get(i).getNum());
                    } catch (NumberFormatException e) {
                        if (cardList.get(i).getNum().equals("J")) {
                            playerCard2 = 10;
                        }
                        if (cardList.get(i).getNum().equals("Q")) {
                            playerCard2 = 10;
                        }
                        if (cardList.get(i).getNum().equals("K")) {
                            playerCard2 = 10;
                        }
                        if (cardList.get(i).getNum().equals("A")) {
                            decideAce();
                        }
                    }
                }
                if (cardList.get(i).getShape().equals("Diamond")) {
                    pcard2.setText("◆" + cardList.get(i).getNum());
                    pcard2.setTextColor(Color.RED);
                    pcard2.setTextSize(30);
                    try {
                        playerCard2 = Integer.parseInt(cardList.get(i).getNum());
                    } catch (NumberFormatException e) {
                        if (cardList.get(i).getNum().equals("J")) {
                            playerCard2 = 10;
                        }
                        if (cardList.get(i).getNum().equals("Q")) {
                            playerCard2 = 10;
                        }
                        if (cardList.get(i).getNum().equals("K")) {
                            playerCard2 = 10;
                        }
                        if (cardList.get(i).getNum().equals("A")) {
                            decideAce();
                        }
                    }
                }
                if (cardList.get(i).getShape().equals("Club")) {
                    pcard2.setText("♣" + cardList.get(i).getNum());
                    pcard2.setTextColor(Color.BLACK);
                    pcard2.setTextSize(30);
                    try {
                        playerCard2 = Integer.parseInt(cardList.get(i).getNum());
                    } catch (NumberFormatException e) {
                        if (cardList.get(i).getNum().equals("J")) {
                            playerCard2 = 10;
                        }
                        if (cardList.get(i).getNum().equals("Q")) {
                            playerCard2 = 10;
                        }
                        if (cardList.get(i).getNum().equals("K")) {
                            playerCard2 = 10;
                        }
                        if (cardList.get(i).getNum().equals("A")) {
                            decideAce();
                        }
                    }
                }
            }
        }
    }
    public void cardopen(View view){ //카드를 클릭할 시 모양을 확인할 수 있다.

        if(view.getId()==R.id.dcard1||view.getId()==R.id.dcard2){
            Toast.makeText(this,"딜러 카드는 열어볼 수 없습니다.",Toast.LENGTH_SHORT).show(); //딜러 카드에는 아무런 처리를 하지 않고 열어볼 수 없게 한다.
        }else if(view.getId()==R.id.pcard1||view.getId()==R.id.pcard2){
           Collections.shuffle(cardList);
            for(int i=0;i<cardCount+1;i++) {
               playerCardset(view);
            }
            cardCount++;
            onclickcount++;
        }

    }

    public void gameset(View view){ //게임을 마친다. Stay or Surrender
        Collections.shuffle(cardList);

        switch (view.getId()){

            case R.id.stay:
                builder=new AlertDialog.Builder(this);
                builder.setTitle("스테이 확인");
                builder.setMessage("이대로 진행합니까?");
                builder.setPositiveButton("아니오", null);
                builder.setNegativeButton("네", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(Blackjack.this,"스테이. 결과를 확인합니다.",Toast.LENGTH_SHORT).show();
                        dealerCardset();
                        resultCulculator(playerCard1, playerCard2, dealerCard1, dealerCard2);
//                        try {
//                            Thread.sleep(2000);
//                            finish();
//                        }catch (Exception e){
//
//                        }
                        stay.setEnabled(false);
                        surrender.setEnabled(false);
                    }
                });
                builder.show();

                break;
            case R.id.surrender:
                builder=new AlertDialog.Builder(this);
                builder.setTitle("서렌더 확인");
                builder.setMessage("서렌더하시겠습니까?");
                builder.setPositiveButton("아니오", null);
                builder.setNegativeButton("네", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dealerCardset();
                        Toast.makeText(Blackjack.this,"서렌더. 베팅액의 절반을 되돌려받습니다.",Toast.LENGTH_SHORT).show();
                        pcard1.setText("");
                        pcard2.setText("");
//                        try {
//                            Thread.sleep(2000);
//                        }catch (Exception e){
//
//                        }
                        finish();
                    }
                });
                builder.show();
                break;
        }

    }



}
