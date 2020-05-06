package com.example.teamProject.service.win;

public class Pager {
	public static final int PAGE_SCALE=20; //占쎈읂占쎌뵠筌욑옙占쎈뼣 野껊슣�뻻�눧�눘�땾
	public static final int BLOCK_SCALE=10;//占쎌넅筌롫��뼣 占쎈읂占쎌뵠筌욑옙占쎈땾
	
	private int curPage; //占쎌겱占쎌삺 占쎈읂占쎌뵠筌욑옙
	private int prevPage; //占쎌뵠占쎌읈 占쎈읂占쎌뵠筌욑옙
	private int nextPage; //占쎈뼄占쎌벉 占쎈읂占쎌뵠筌욑옙
	private int totPage; //占쎌읈筌ｏ옙 占쎈읂占쎌뵠筌욑옙 揶쏉옙占쎈땾
	private int totBlock; //占쎌읈筌ｏ옙 占쎈읂占쎌뵠筌욑옙�뇡遺얠쨯 揶쏉옙占쎈땾
	private int curBlock; //占쎌겱占쎌삺 �뇡遺얠쨯
	private int prevBlock; //占쎌뵠占쎌읈 �뇡遺얠쨯
	private int nextBlock; //占쎈뼄占쎌벉 �뇡遺얠쨯
	private int pageBegin; // #{start} 癰귨옙占쎈땾占쎈퓠 占쎌읈占쎈뼎占쎈쭍 揶쏉옙
	private int pageEnd; // #{end} 癰귨옙占쎈땾占쎈퓠 占쎌읈占쎈뼎占쎈쭍 揶쏉옙
	private int blockBegin; //�뇡遺얠쨯占쎌벥 占쎈뻻占쎌삂占쎈읂占쎌뵠筌욑옙 甕곕뜇�깈
	private int blockEnd; //�뇡遺얠쨯占쎌벥 占쎄국占쎈읂占쎌뵠筌욑옙 甕곕뜇�깈
	
	public Pager(int count, int curPage) {
		curBlock = 1; //占쎌겱占쎌삺�뇡遺얠쨯 甕곕뜇�깈
		this.curPage = curPage; //占쎌겱占쎌삺 占쎈읂占쎌뵠筌욑옙 甕곕뜇�깈
		setTotPage(count); //占쎌읈筌ｏ옙 占쎈읂占쎌뵠筌욑옙 揶쏉옙占쎈땾 �④쑴沅�
		setPageRange(); // #{start}, #{end} 揶쏉옙 �④쑴沅�
		setTotBlock(); // 占쎌읈筌ｏ옙 �뇡遺얠쨯 揶쏉옙占쎈땾 �④쑴沅�
		setBlockRange(); //�뇡遺얠쨯占쎌벥 占쎈뻻占쎌삂,占쎄국 甕곕뜇�깈 �④쑴沅�
	}
	public void setBlockRange() {
		//占쎌뜚占쎈릭占쎈뮉 占쎈읂占쎌뵠筌욑옙揶쏉옙 筌뤿돃苡뀐쭪占� �뇡遺얠쨯占쎈퓠 占쎈꺗占쎈릭占쎈뮉筌욑옙 �④쑴沅�
		curBlock=(curPage-1)/BLOCK_SCALE + 1;
		//�뇡遺얠쨯占쎌벥 占쎈뻻占쎌삂占쎈읂占쎌뵠筌욑옙,占쎄국占쎈읂占쎌뵠筌욑옙 甕곕뜇�깈 �④쑴沅�
		blockBegin=(curBlock-1)*BLOCK_SCALE+1;
		blockEnd=blockBegin+BLOCK_SCALE-1;
		//筌띾뜆占쏙쭕占� �뇡遺얠쨯 甕곕뜇�깈揶쏉옙 甕곕뗄�맄�몴占� �룯�뜃�궢占쎈릭筌욑옙 占쎈륫占쎈즲嚥∽옙 筌ｌ꼶�봺
		if(blockEnd > totPage) {
			blockEnd = totPage;
		}
		//[占쎌뵠占쎌읈][占쎈뼄占쎌벉]占쎌뱽 占쎈땭占쏙옙占쎌뱽 占쎈르 占쎌뵠占쎈짗占쎈막 占쎈읂占쎌뵠筌욑옙 甕곕뜇�깈
		prevPage=(curBlock==1) ? 1 : (curBlock-1)*BLOCK_SCALE;
		nextPage=curBlock>totBlock ? (curBlock*BLOCK_SCALE)
				: (curBlock*BLOCK_SCALE)+1;
		//筌띾뜆占쏙쭕占� 占쎈읂占쎌뵠筌욑옙揶쏉옙 甕곕뗄�맄�몴占� �룯�뜃�궢占쎈릭筌욑옙 占쎈륫占쎈즲嚥∽옙 筌ｌ꼶�봺
		if(nextPage >= totPage) {
			nextPage=totPage;
		}
	}
	
	//�뇡遺얠쨯占쎌벥 揶쏉옙占쎈땾 �④쑴沅�
	public void setTotBlock() {
		totBlock = (int)Math.ceil(totPage*1.0 / BLOCK_SCALE);
	}
	
// where rn between #{start} and #{end}占쎈퓠 占쎌뿯占쎌젾占쎈쭍 揶쏉옙		
	public void setPageRange() {
// 占쎈뻻占쎌삂甕곕뜇�깈=(占쎌겱占쎌삺占쎈읂占쎌뵠筌욑옙-1)x占쎈읂占쎌뵠筌욑옙占쎈뼣 野껊슣�뻻�눧�눘�땾 + 1
// 占쎄국甕곕뜇�깈=占쎈뻻占쎌삂甕곕뜇�깈 + 占쎈읂占쎌뵠筌욑옙占쎈뼣 野껊슣�뻻�눧�눘�땾 - 1		
		pageBegin = (curPage-1) * PAGE_SCALE + 1;
		pageEnd = pageBegin + PAGE_SCALE - 1;
	}
	
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getPrevPage() {
		return prevPage;
	}
	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getTotPage() {
		return totPage;
	}
	//占쎌읈筌ｏ옙 占쎈읂占쎌뵠筌욑옙 揶쏉옙占쎈땾 �④쑴沅�
	public void setTotPage(int count) {
// Math.ceil() 占쎌궞�뵳占�		
		totPage = (int)Math.ceil(count*1.0 / PAGE_SCALE);
	}
	public int getTotBlock() {
		return totBlock;
	}
	public void setTotBlock(int totBlock) {
		this.totBlock = totBlock;
	}
	public int getCurBlock() {
		return curBlock;
	}
	public void setCurBlock(int curBlock) {
		this.curBlock = curBlock;
	}
	public int getPrevBlock() {
		return prevBlock;
	}
	public void setPrevBlock(int prevBlock) {
		this.prevBlock = prevBlock;
	}
	public int getNextBlock() {
		return nextBlock;
	}
	public void setNextBlock(int nextBlock) {
		this.nextBlock = nextBlock;
	}
	public int getPageBegin() {
		return pageBegin;
	}
	public void setPageBegin(int pageBegin) {
		this.pageBegin = pageBegin;
	}
	public int getPageEnd() {
		return pageEnd;
	}
	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}
	public int getBlockBegin() {
		return blockBegin;
	}
	public void setBlockBegin(int blockBegin) {
		this.blockBegin = blockBegin;
	}
	public int getBlockEnd() {
		return blockEnd;
	}
	public void setBlockEnd(int blockEnd) {
		this.blockEnd = blockEnd;
	}

}
