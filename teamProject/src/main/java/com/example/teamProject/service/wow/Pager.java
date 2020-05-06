package com.example.teamProject.service.wow;

public class Pager {
	public static final int PAGE_SCALE=20; //�뜝�럥�쓡�뜝�럩逾좂춯�쉻�삕�뜝�럥堉� �뇦猿딆뒩占쎈뻣占쎈닱占쎈닔占쎈빢
	public static final int BLOCK_SCALE=10;//�뜝�럩�꼨嶺뚮∥占쏙옙堉� �뜝�럥�쓡�뜝�럩逾좂춯�쉻�삕�뜝�럥�빢
	
	private int curPage; //�뜝�럩寃긷뜝�럩�궨 �뜝�럥�쓡�뜝�럩逾좂춯�쉻�삕
	private int prevPage; //�뜝�럩逾졾뜝�럩�쓧 �뜝�럥�쓡�뜝�럩逾좂춯�쉻�삕
	private int nextPage; //�뜝�럥堉꾢뜝�럩踰� �뜝�럥�쓡�뜝�럩逾좂춯�쉻�삕
	private int totPage; //�뜝�럩�쓧嶺뚳퐦�삕 �뜝�럥�쓡�뜝�럩逾좂춯�쉻�삕 �뤆�룊�삕�뜝�럥�빢
	private int totBlock; //�뜝�럩�쓧嶺뚳퐦�삕 �뜝�럥�쓡�뜝�럩逾좂춯�쉻�삕占쎈눀�겫�뼚夷� �뤆�룊�삕�뜝�럥�빢
	private int curBlock; //�뜝�럩寃긷뜝�럩�궨 占쎈눀�겫�뼚夷�
	private int prevBlock; //�뜝�럩逾졾뜝�럩�쓧 占쎈눀�겫�뼚夷�
	private int nextBlock; //�뜝�럥堉꾢뜝�럩踰� 占쎈눀�겫�뼚夷�
	private int pageBegin; // #{start} �솻洹⑥삕�뜝�럥�빢�뜝�럥�뱺 �뜝�럩�쓧�뜝�럥堉롥뜝�럥彛� �뤆�룊�삕
	private int pageEnd; // #{end} �솻洹⑥삕�뜝�럥�빢�뜝�럥�뱺 �뜝�럩�쓧�뜝�럥堉롥뜝�럥彛� �뤆�룊�삕
	private int blockBegin; //占쎈눀�겫�뼚夷��뜝�럩踰� �뜝�럥六삣뜝�럩�굚�뜝�럥�쓡�뜝�럩逾좂춯�쉻�삕 �뵓怨뺣쐡占쎄퉰
	private int blockEnd; //占쎈눀�겫�뼚夷��뜝�럩踰� �뜝�럡援��뜝�럥�쓡�뜝�럩逾좂춯�쉻�삕 �뵓怨뺣쐡占쎄퉰
	
	public Pager(int count, int curPage) {
		curBlock = 1; //�뜝�럩寃긷뜝�럩�궨占쎈눀�겫�뼚夷� �뵓怨뺣쐡占쎄퉰
		this.curPage = curPage; //�뜝�럩寃긷뜝�럩�궨 �뜝�럥�쓡�뜝�럩逾좂춯�쉻�삕 �뵓怨뺣쐡占쎄퉰
		setTotPage(count); //�뜝�럩�쓧嶺뚳퐦�삕 �뜝�럥�쓡�뜝�럩逾좂춯�쉻�삕 �뤆�룊�삕�뜝�럥�빢 占썩몿�뫒亦낉옙
		setPageRange(); // #{start}, #{end} �뤆�룊�삕 占썩몿�뫒亦낉옙
		setTotBlock(); // �뜝�럩�쓧嶺뚳퐦�삕 占쎈눀�겫�뼚夷� �뤆�룊�삕�뜝�럥�빢 占썩몿�뫒亦낉옙
		setBlockRange(); //占쎈눀�겫�뼚夷��뜝�럩踰� �뜝�럥六삣뜝�럩�굚,�뜝�럡援� �뵓怨뺣쐡占쎄퉰 占썩몿�뫒亦낉옙
	}
	public void setBlockRange() {
		//�뜝�럩�쐸�뜝�럥由��뜝�럥裕� �뜝�럥�쓡�뜝�럩逾좂춯�쉻�삕�뤆�룊�삕 嶺뚮ㅏ�룂�떋�먯�ゅ뜝占� 占쎈눀�겫�뼚夷��뜝�럥�뱺 �뜝�럥爰쀥뜝�럥由��뜝�럥裕됬춯�쉻�삕 占썩몿�뫒亦낉옙
		curBlock=(curPage-1)/BLOCK_SCALE + 1;
		//占쎈눀�겫�뼚夷��뜝�럩踰� �뜝�럥六삣뜝�럩�굚�뜝�럥�쓡�뜝�럩逾좂춯�쉻�삕,�뜝�럡援��뜝�럥�쓡�뜝�럩逾좂춯�쉻�삕 �뵓怨뺣쐡占쎄퉰 占썩몿�뫒亦낉옙
		blockBegin=(curBlock-1)*BLOCK_SCALE+1;
		blockEnd=blockBegin+BLOCK_SCALE-1;
		//嶺뚮씭�쐠�뜝�룞彛뺝뜝占� 占쎈눀�겫�뼚夷� �뵓怨뺣쐡占쎄퉰�뤆�룊�삕 �뵓怨뺣뾼占쎈쭊占쎈ご�뜝占� 占쎈／占쎈쐝占쎄땁�뜝�럥由�嶺뚯쉻�삕 �뜝�럥瑜ュ뜝�럥利꿨슖�댙�삕 嶺뚳퐣瑗띰옙遊�
		if(blockEnd > totPage) {
			blockEnd = totPage;
		}
		//[�뜝�럩逾졾뜝�럩�쓧][�뜝�럥堉꾢뜝�럩踰�]�뜝�럩諭� �뜝�럥�빆�뜝�룞�삕�뜝�럩諭� �뜝�럥瑜� �뜝�럩逾졾뜝�럥吏쀥뜝�럥留� �뜝�럥�쓡�뜝�럩逾좂춯�쉻�삕 �뵓怨뺣쐡占쎄퉰
		prevPage=(curBlock==1) ? 1 : (curBlock-1)*BLOCK_SCALE;
		nextPage=curBlock>totBlock ? (curBlock*BLOCK_SCALE)
				: (curBlock*BLOCK_SCALE)+1;
		//嶺뚮씭�쐠�뜝�룞彛뺝뜝占� �뜝�럥�쓡�뜝�럩逾좂춯�쉻�삕�뤆�룊�삕 �뵓怨뺣뾼占쎈쭊占쎈ご�뜝占� 占쎈／占쎈쐝占쎄땁�뜝�럥由�嶺뚯쉻�삕 �뜝�럥瑜ュ뜝�럥利꿨슖�댙�삕 嶺뚳퐣瑗띰옙遊�
		if(nextPage >= totPage) {
			nextPage=totPage;
		}
	}
	
	//占쎈눀�겫�뼚夷��뜝�럩踰� �뤆�룊�삕�뜝�럥�빢 占썩몿�뫒亦낉옙
	public void setTotBlock() {
		totBlock = (int)Math.ceil(totPage*1.0 / BLOCK_SCALE);
	}
	
// where rn between #{start} and #{end}�뜝�럥�뱺 �뜝�럩肉��뜝�럩�졑�뜝�럥彛� �뤆�룊�삕		
	public void setPageRange() {
// �뜝�럥六삣뜝�럩�굚�뵓怨뺣쐡占쎄퉰=(�뜝�럩寃긷뜝�럩�궨�뜝�럥�쓡�뜝�럩逾좂춯�쉻�삕-1)x�뜝�럥�쓡�뜝�럩逾좂춯�쉻�삕�뜝�럥堉� �뇦猿딆뒩占쎈뻣占쎈닱占쎈닔占쎈빢 + 1
// �뜝�럡援��뵓怨뺣쐡占쎄퉰=�뜝�럥六삣뜝�럩�굚�뵓怨뺣쐡占쎄퉰 + �뜝�럥�쓡�뜝�럩逾좂춯�쉻�삕�뜝�럥堉� �뇦猿딆뒩占쎈뻣占쎈닱占쎈닔占쎈빢 - 1		
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
	//�뜝�럩�쓧嶺뚳퐦�삕 �뜝�럥�쓡�뜝�럩逾좂춯�쉻�삕 �뤆�룊�삕�뜝�럥�빢 占썩몿�뫒亦낉옙
	public void setTotPage(int count) {
// Math.ceil() �뜝�럩沅욑옙逾녑뜝占�		
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
