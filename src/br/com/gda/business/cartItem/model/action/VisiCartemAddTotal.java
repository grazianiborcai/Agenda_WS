package br.com.gda.business.cartItem.model.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.business.masterData.info.common.CartFlag;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionMultiVisitorTemplate;

final class VisiCartemAddTotal extends ActionMultiVisitorTemplate<CartemInfo> {
	private CartemInfo total;
	private List<CartemInfo> allItems;
	
	
	public VisiCartemAddTotal() {
		super();
	}
	
	
	
	@Override protected boolean buildListHook(List<CartemInfo> infoRecords, boolean hasNext) {
		boolean token = super.NOT_TAKEN;
		
		if (token == super.NOT_TAKEN)
			token = buildTotal(infoRecords);
		
		if (token == super.NOT_TAKEN)
			token = buildAllItems(infoRecords);
		
		return token;
	}
	
	
	
	private boolean buildTotal(List<CartemInfo> infoRecords) {
		if (isTotal(infoRecords) == super.NOT_FLAGGED)
			return super.NOT_TAKEN;
		
		initTotal();
		buildRecordTotal(infoRecords);
		
		return super.IS_TAKEN;
	}
	
	
	
	private boolean isTotal(List<CartemInfo> infoRecords) {
		for (CartemInfo eachRecord: infoRecords) {
			if (eachRecord.recordFlag != CartFlag.TOTAL.getFlagId())
				return super.NOT_FLAGGED;
		}
		
		return super.FLAGGED;
	}
	
	
	
	private void initTotal() {
		total = null;
	}
	
	
	
	private void buildRecordTotal(List<CartemInfo> infoRecords) {
		CartemInfo firstRow = infoRecords.get(0);
		total = firstRow;
	}
	
	
	
	private boolean buildAllItems(List<CartemInfo> infoRecords) {
		if (isAllItem(infoRecords) == super.NOT_FLAGGED)
			return super.NOT_TAKEN;
		
		initAllItems();
		buildListAllItems(infoRecords);
		
		return super.IS_TAKEN;
	}
	
	
	
	private boolean isAllItem(List<CartemInfo> infoRecords) {
		for (CartemInfo eachRecord: infoRecords) {
			if (eachRecord.recordFlag != CartFlag.ALL.getFlagId())
				return super.NOT_FLAGGED;
		}
		
		return super.FLAGGED;
	}
	
	
	
	private void initAllItems() {
		allItems = new ArrayList<>();
	}
	
	
	
	private void buildListAllItems(List<CartemInfo> infoRecords) {
		allItems.addAll(infoRecords);
	}
	
	
	
	@Override protected List<CartemInfo> executeHook() {
		return addTotalToAllItems();
	}
	
	
	
	private List<CartemInfo> addTotalToAllItems() {
		checkList();
		return add();
	}
	
	
	
	private void checkList() {
		if (allItems == null || allItems.isEmpty()) {
			logException(new IllegalStateException("allItems" + SystemMessage.ACTION_NOT_INIT));
			throw new IllegalStateException("allItems" + SystemMessage.ACTION_NOT_INIT);
		}
		
		if (total == null) {
			logException(new IllegalStateException("total" + SystemMessage.ACTION_NOT_INIT));
			throw new IllegalStateException("total" + SystemMessage.ACTION_NOT_INIT);
		}
	}
	
	
	
	private List<CartemInfo> add() {
		List<CartemInfo> results = new ArrayList<>();
		
		for (CartemInfo eachItem : allItems) {
			CartemInfo cloned = makeClone(eachItem);
			results.add(cloned);
		}		
		
		CartemInfo cloned = makeClone(total);
		results.add(cloned);
		
		return results;
	}
	
	
	
	private CartemInfo makeClone(CartemInfo recordInfo) {
		try {
			return (CartemInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
