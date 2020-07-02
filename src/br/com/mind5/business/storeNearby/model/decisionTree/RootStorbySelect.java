package br.com.mind5.business.storeNearby.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.model.action.LazyStorbyEnforceDistance;
import br.com.mind5.business.storeNearby.model.action.LazyStorbyMergeAddress;
import br.com.mind5.business.storeNearby.model.action.LazyStorbyMergeComplis;
import br.com.mind5.business.storeNearby.model.action.LazyStorbyMergeFimist;
import br.com.mind5.business.storeNearby.model.action.LazyStorbyNodeDistrict;
import br.com.mind5.business.storeNearby.model.checker.StorbyCheckLangu;
import br.com.mind5.business.storeNearby.model.checker.StorbyCheckOwner;
import br.com.mind5.business.storeNearby.model.checker.StorbyCheckRead;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootStorbySelect extends DeciTreeTemplateReadV2<StorbyInfo> {
	
	public RootStorbySelect(DeciTreeOption<StorbyInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StorbyInfo> buildCheckerHook(DeciTreeOption<StorbyInfo> option) {
		List<ModelCheckerV1<StorbyInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StorbyInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StorbyCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new StorbyCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new StorbyCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StorbyInfo>> buildActionsOnPassedHook(DeciTreeOption<StorbyInfo> option) {
		List<ActionStdV1<StorbyInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<StorbyInfo> nodeHash = new NodeStorbyHash(option).toAction();
		ActionLazyV1<StorbyInfo> nodeDistrict = new LazyStorbyNodeDistrict(option.conn, option.schemaName);
		ActionLazyV1<StorbyInfo> mergeComplis = new LazyStorbyMergeComplis(option.conn, option.schemaName);
		ActionLazyV1<StorbyInfo> mergeAddress = new LazyStorbyMergeAddress(option.conn, option.schemaName);
		ActionLazyV1<StorbyInfo> enforceDistance = new LazyStorbyEnforceDistance(option.conn, option.schemaName);
		ActionLazyV1<StorbyInfo> mergeFimist = new LazyStorbyMergeFimist(option.conn, option.schemaName);
		
		nodeHash.addPostAction(nodeDistrict);
		nodeDistrict.addPostAction(mergeComplis);
		mergeComplis.addPostAction(mergeAddress);
		mergeAddress.addPostAction(enforceDistance);
		enforceDistance.addPostAction(mergeFimist);
		
		actions.add(nodeHash);			
		return actions;
	}
	
	
	
	@Override public void close() {
		super.close();
	}
}
