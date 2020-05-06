package com.example.teamProject.service.main;

public class Pager {
	public static final int PAGE_SCALE=20; //占쎈쐻占쎈윥占쎌뱻占쎈쐻占쎈윪�얠쥉異�占쎌돸占쎌굲占쎈쐻占쎈윥�젆占� 占쎈눇�뙼�봿�뮝�뜝�럥六ｅ뜝�럥�떛�뜝�럥�땾�뜝�럥鍮�
	public static final int BLOCK_SCALE=10;//占쎈쐻占쎈윪占쎄섀癲ル슢�닪�뜝�룞�삕�젆占� 占쎈쐻占쎈윥占쎌뱻占쎈쐻占쎈윪�얠쥉異�占쎌돸占쎌굲占쎈쐻占쎈윥占쎈묄
	
	private int curPage; //占쎈쐻占쎈윪野껉막�쐻占쎈윪占쎄땍 占쎈쐻占쎈윥占쎌뱻占쎈쐻占쎈윪�얠쥉異�占쎌돸占쎌굲
	private int prevPage; //占쎈쐻占쎈윪�얠±�쐻占쎈윪占쎌벁 占쎈쐻占쎈윥占쎌뱻占쎈쐻占쎈윪�얠쥉異�占쎌돸占쎌굲
	private int nextPage; //占쎈쐻占쎈윥�젆袁��쐻占쎈윪甕곤옙 占쎈쐻占쎈윥占쎌뱻占쎈쐻占쎈윪�얠쥉異�占쎌돸占쎌굲
	private int totPage; //占쎈쐻占쎈윪占쎌벁癲ル슪�맔占쎌굲 占쎈쐻占쎈윥占쎌뱻占쎈쐻占쎈윪�얠쥉異�占쎌돸占쎌굲 占쎈쨬占쎈즸占쎌굲占쎈쐻占쎈윥占쎈묄
	private int totBlock; //占쎈쐻占쎈윪占쎌벁癲ル슪�맔占쎌굲 占쎈쐻占쎈윥占쎌뱻占쎈쐻占쎈윪�얠쥉異�占쎌돸占쎌굲�뜝�럥��占쎄껀占쎈폏鸚뤄옙 占쎈쨬占쎈즸占쎌굲占쎈쐻占쎈윥占쎈묄
	private int curBlock; //占쎈쐻占쎈윪野껉막�쐻占쎈윪占쎄땍 �뜝�럥��占쎄껀占쎈폏鸚뤄옙
	private int prevBlock; //占쎈쐻占쎈윪�얠±�쐻占쎈윪占쎌벁 �뜝�럥��占쎄껀占쎈폏鸚뤄옙
	private int nextBlock; //占쎈쐻占쎈윥�젆袁��쐻占쎈윪甕곤옙 �뜝�럥��占쎄껀占쎈폏鸚뤄옙
	private int pageBegin; // #{start} 占쎌녃域밟뫁�굲占쎈쐻占쎈윥占쎈묄占쎈쐻占쎈윥占쎈군 占쎈쐻占쎈윪占쎌벁占쎈쐻占쎈윥�젆濡λ쐻占쎈윥壤쏉옙 占쎈쨬占쎈즸占쎌굲
	private int pageEnd; // #{end} 占쎌녃域밟뫁�굲占쎈쐻占쎈윥占쎈묄占쎈쐻占쎈윥占쎈군 占쎈쐻占쎈윪占쎌벁占쎈쐻占쎈윥�젆濡λ쐻占쎈윥壤쏉옙 占쎈쨬占쎈즸占쎌굲
	private int blockBegin; //�뜝�럥��占쎄껀占쎈폏鸚뤄옙占쎈쐻占쎈윪甕곤옙 占쎈쐻占쎈윥筌묒궍�쐻占쎈윪占쎄탾占쎈쐻占쎈윥占쎌뱻占쎈쐻占쎈윪�얠쥉異�占쎌돸占쎌굲 占쎈탶�⑤베�맇�뜝�럡�돭
	private int blockEnd; //�뜝�럥��占쎄껀占쎈폏鸚뤄옙占쎈쐻占쎈윪甕곤옙 占쎈쐻占쎈윞�뤃占쏙옙�쐻占쎈윥占쎌뱻占쎈쐻占쎈윪�얠쥉異�占쎌돸占쎌굲 占쎈탶�⑤베�맇�뜝�럡�돭
	
	public Pager(int count, int curPage) {
		curBlock = 1; //占쎈쐻占쎈윪野껉막�쐻占쎈윪占쎄땍�뜝�럥��占쎄껀占쎈폏鸚뤄옙 占쎈탶�⑤베�맇�뜝�럡�돭
		this.curPage = curPage; //占쎈쐻占쎈윪野껉막�쐻占쎈윪占쎄땍 占쎈쐻占쎈윥占쎌뱻占쎈쐻占쎈윪�얠쥉異�占쎌돸占쎌굲 占쎈탶�⑤베�맇�뜝�럡�돭
		setTotPage(count); //占쎈쐻占쎈윪占쎌벁癲ル슪�맔占쎌굲 占쎈쐻占쎈윥占쎌뱻占쎈쐻占쎈윪�얠쥉異�占쎌돸占쎌굲 占쎈쨬占쎈즸占쎌굲占쎈쐻占쎈윥占쎈묄 �뜝�뜦紐울옙維믢벧�굢�삕
		setPageRange(); // #{start}, #{end} 占쎈쨬占쎈즸占쎌굲 �뜝�뜦紐울옙維믢벧�굢�삕
		setTotBlock(); // 占쎈쐻占쎈윪占쎌벁癲ル슪�맔占쎌굲 �뜝�럥��占쎄껀占쎈폏鸚뤄옙 占쎈쨬占쎈즸占쎌굲占쎈쐻占쎈윥占쎈묄 �뜝�뜦紐울옙維믢벧�굢�삕
		setBlockRange(); //�뜝�럥��占쎄껀占쎈폏鸚뤄옙占쎈쐻占쎈윪甕곤옙 占쎈쐻占쎈윥筌묒궍�쐻占쎈윪占쎄탾,占쎈쐻占쎈윞�뤃占� 占쎈탶�⑤베�맇�뜝�럡�돭 �뜝�뜦紐울옙維믢벧�굢�삕
	}
	public void setBlockRange() {
		//占쎈쐻占쎈윪占쎌맱占쎈쐻占쎈윥�뵳占쏙옙�쐻占쎈윥獒뺧옙 占쎈쐻占쎈윥占쎌뱻占쎈쐻占쎈윪�얠쥉異�占쎌돸占쎌굲占쎈쨬占쎈즸占쎌굲 癲ル슢�뀖占쎈즰占쎈뼀占쎈Ŋ占썬굝�쐻�뜝占� �뜝�럥��占쎄껀占쎈폏鸚뤄옙占쎈쐻占쎈윥占쎈군 占쎈쐻占쎈윥�댆�λ쐻占쎈윥�뵳占쏙옙�쐻占쎈윥獒뺣맟異�占쎌돸占쎌굲 �뜝�뜦紐울옙維믢벧�굢�삕
		curBlock=(curPage-1)/BLOCK_SCALE + 1;
		//�뜝�럥��占쎄껀占쎈폏鸚뤄옙占쎈쐻占쎈윪甕곤옙 占쎈쐻占쎈윥筌묒궍�쐻占쎈윪占쎄탾占쎈쐻占쎈윥占쎌뱻占쎈쐻占쎈윪�얠쥉異�占쎌돸占쎌굲,占쎈쐻占쎈윞�뤃占쏙옙�쐻占쎈윥占쎌뱻占쎈쐻占쎈윪�얠쥉異�占쎌돸占쎌굲 占쎈탶�⑤베�맇�뜝�럡�돭 �뜝�뜦紐울옙維믢벧�굢�삕
		blockBegin=(curBlock-1)*BLOCK_SCALE+1;
		blockEnd=blockBegin+BLOCK_SCALE-1;
		//癲ル슢�뵯占쎌맆占쎈쐻占쎈짗壤쏅틶�쐻�뜝占� �뜝�럥��占쎄껀占쎈폏鸚뤄옙 占쎈탶�⑤베�맇�뜝�럡�돭占쎈쨬占쎈즸占쎌굲 占쎈탶�⑤베毓쇔뜝�럥彛듿뜝�럥�걫占쎈쐻�뜝占� �뜝�럥竊뤷뜝�럥�맃�뜝�럡�븕占쎈쐻占쎈윥�뵳占쏙┼�슣�돸占쎌굲 占쎈쐻占쎈윥�몴�깷�쐻占쎈윥筌앷엥�뒙占쎈뙔占쎌굲 癲ル슪�맋�몭�씛�삕�걡占�
		if(blockEnd > totPage) {
			blockEnd = totPage;
		}
		//[占쎈쐻占쎈윪�얠±�쐻占쎈윪占쎌벁][占쎈쐻占쎈윥�젆袁��쐻占쎈윪甕곤옙]占쎈쐻占쎈윪獄�占� 占쎈쐻占쎈윥占쎈퉮占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈윪獄�占� 占쎈쐻占쎈윥�몴占� 占쎈쐻占쎈윪�얠±�쐻占쎈윥筌욎�λ쐻占쎈윥筌랃옙 占쎈쐻占쎈윥占쎌뱻占쎈쐻占쎈윪�얠쥉異�占쎌돸占쎌굲 占쎈탶�⑤베�맇�뜝�럡�돭
		prevPage=(curBlock==1) ? 1 : (curBlock-1)*BLOCK_SCALE;
		nextPage=curBlock>totBlock ? (curBlock*BLOCK_SCALE)
				: (curBlock*BLOCK_SCALE)+1;
		//癲ル슢�뵯占쎌맆占쎈쐻占쎈짗壤쏅틶�쐻�뜝占� 占쎈쐻占쎈윥占쎌뱻占쎈쐻占쎈윪�얠쥉異�占쎌돸占쎌굲占쎈쨬占쎈즸占쎌굲 占쎈탶�⑤베毓쇔뜝�럥彛듿뜝�럥�걫占쎈쐻�뜝占� �뜝�럥竊뤷뜝�럥�맃�뜝�럡�븕占쎈쐻占쎈윥�뵳占쏙┼�슣�돸占쎌굲 占쎈쐻占쎈윥�몴�깷�쐻占쎈윥筌앷엥�뒙占쎈뙔占쎌굲 癲ル슪�맋�몭�씛�삕�걡占�
		if(nextPage >= totPage) {
			nextPage=totPage;
		}
	}
	
	//�뜝�럥��占쎄껀占쎈폏鸚뤄옙占쎈쐻占쎈윪甕곤옙 占쎈쨬占쎈즸占쎌굲占쎈쐻占쎈윥占쎈묄 �뜝�뜦紐울옙維믢벧�굢�삕
	public void setTotBlock() {
		totBlock = (int)Math.ceil(totPage*1.0 / BLOCK_SCALE);
	}
	
// where rn between #{start} and #{end}占쎈쐻占쎈윥占쎈군 占쎈쐻占쎈윪�굢占쏙옙�쐻占쎈윪占쎌죷占쎈쐻占쎈윥壤쏉옙 占쎈쨬占쎈즸占쎌굲		
	public void setPageRange() {
// 占쎈쐻占쎈윥筌묒궍�쐻占쎈윪占쎄탾占쎈탶�⑤베�맇�뜝�럡�돭=(占쎈쐻占쎈윪野껉막�쐻占쎈윪占쎄땍占쎈쐻占쎈윥占쎌뱻占쎈쐻占쎈윪�얠쥉異�占쎌돸占쎌굲-1)x占쎈쐻占쎈윥占쎌뱻占쎈쐻占쎈윪�얠쥉異�占쎌돸占쎌굲占쎈쐻占쎈윥�젆占� 占쎈눇�뙼�봿�뮝�뜝�럥六ｅ뜝�럥�떛�뜝�럥�땾�뜝�럥鍮� + 1
// 占쎈쐻占쎈윞�뤃占쏙옙逾볠�⑤베�맇�뜝�럡�돭=占쎈쐻占쎈윥筌묒궍�쐻占쎈윪占쎄탾占쎈탶�⑤베�맇�뜝�럡�돭 + 占쎈쐻占쎈윥占쎌뱻占쎈쐻占쎈윪�얠쥉異�占쎌돸占쎌굲占쎈쐻占쎈윥�젆占� 占쎈눇�뙼�봿�뮝�뜝�럥六ｅ뜝�럥�떛�뜝�럥�땾�뜝�럥鍮� - 1		
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
	//占쎈쐻占쎈윪占쎌벁癲ル슪�맔占쎌굲 占쎈쐻占쎈윥占쎌뱻占쎈쐻占쎈윪�얠쥉異�占쎌돸占쎌굲 占쎈쨬占쎈즸占쎌굲占쎈쐻占쎈윥占쎈묄 �뜝�뜦紐울옙維믢벧�굢�삕
	public void setTotPage(int count) {
// Math.ceil() 占쎈쐻占쎈윪亦낆쉻�삕�얜뀘�쐻�뜝占�		
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
