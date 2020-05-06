package com.example.teamProject.service.sud;

public class Pager {
	public static final int PAGE_SCALE=20; //�럹�씠吏��떦 寃뚯떆臾쇱닔
	public static final int BLOCK_SCALE=10;//�솕硫대떦 �럹�씠吏��닔
	
	private int curPage; //�쁽�옱 �럹�씠吏�
	private int prevPage; //�씠�쟾 �럹�씠吏�
	private int nextPage; //�떎�쓬 �럹�씠吏�
	private int totPage; //�쟾泥� �럹�씠吏� 媛��닔
	private int totBlock; //�쟾泥� �럹�씠吏�釉붾줉 媛��닔
	private int curBlock; //�쁽�옱 釉붾줉
	private int prevBlock; //�씠�쟾 釉붾줉
	private int nextBlock; //�떎�쓬 釉붾줉
	private int pageBegin; // #{start} 蹂��닔�뿉 �쟾�떖�맆 媛�
	private int pageEnd; // #{end} 蹂��닔�뿉 �쟾�떖�맆 媛�
	private int blockBegin; //釉붾줉�쓽 �떆�옉�럹�씠吏� 踰덊샇
	private int blockEnd; //釉붾줉�쓽 �걹�럹�씠吏� 踰덊샇
	
	public Pager(int count, int curPage) {
		curBlock = 1; //�쁽�옱釉붾줉 踰덊샇
		this.curPage = curPage; //�쁽�옱 �럹�씠吏� 踰덊샇
		setTotPage(count); //�쟾泥� �럹�씠吏� 媛��닔 怨꾩궛
		setPageRange(); // #{start}, #{end} 媛� 怨꾩궛
		setTotBlock(); // �쟾泥� 釉붾줉 媛��닔 怨꾩궛
		setBlockRange(); //釉붾줉�쓽 �떆�옉,�걹 踰덊샇 怨꾩궛
	}
	public void setBlockRange() {
		//�썝�븯�뒗 �럹�씠吏�媛� 紐뉖쾲吏� 釉붾줉�뿉 �냽�븯�뒗吏� 怨꾩궛
		curBlock=(curPage-1)/BLOCK_SCALE + 1;
		//釉붾줉�쓽 �떆�옉�럹�씠吏�,�걹�럹�씠吏� 踰덊샇 怨꾩궛
		blockBegin=(curBlock-1)*BLOCK_SCALE+1;
		blockEnd=blockBegin+BLOCK_SCALE-1;
		//留덉�留� 釉붾줉 踰덊샇媛� 踰붿쐞瑜� 珥덇낵�븯吏� �븡�룄濡� 泥섎━
		if(blockEnd > totPage) {
			blockEnd = totPage;
		}
		//[�씠�쟾][�떎�쓬]�쓣 �닃���쓣 �븣 �씠�룞�븷 �럹�씠吏� 踰덊샇
		prevPage=(curBlock==1) ? 1 : (curBlock-1)*BLOCK_SCALE;
		nextPage=curBlock>totBlock ? (curBlock*BLOCK_SCALE)
				: (curBlock*BLOCK_SCALE)+1;
		//留덉�留� �럹�씠吏�媛� 踰붿쐞瑜� 珥덇낵�븯吏� �븡�룄濡� 泥섎━
		if(nextPage >= totPage) {
			nextPage=totPage;
		}
	}
	
	//釉붾줉�쓽 媛��닔 怨꾩궛
	public void setTotBlock() {
		totBlock = (int)Math.ceil(totPage*1.0 / BLOCK_SCALE);
	}
	
// where rn between #{start} and #{end}�뿉 �엯�젰�맆 媛�		
	public void setPageRange() {
// �떆�옉踰덊샇=(�쁽�옱�럹�씠吏�-1)x�럹�씠吏��떦 寃뚯떆臾쇱닔 + 1
// �걹踰덊샇=�떆�옉踰덊샇 + �럹�씠吏��떦 寃뚯떆臾쇱닔 - 1		
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
	//�쟾泥� �럹�씠吏� 媛��닔 怨꾩궛
	public void setTotPage(int count) {
// Math.ceil() �삱由�		
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
