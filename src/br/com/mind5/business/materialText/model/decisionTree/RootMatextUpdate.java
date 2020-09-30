package br.com.mind5.business.materialText.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.model.action.LazyMatextDaoUpdate;
import br.com.mind5.business.materialText.model.action.LazyMatextEnforceLChanged;
import br.com.mind5.business.materialText.model.action.LazyMatextEnforceTxtSearch;
import br.com.mind5.business.materialText.model.action.LazyMatextMergeUsername;
import br.com.mind5.business.materialText.model.action.LazyMatextNodeDefaultL1;
import br.com.mind5.business.materialText.model.action.LazyMatextNodePostUpdate;
import br.com.mind5.business.materialText.model.action.LazyMatextRootSelect;
import br.com.mind5.business.materialText.model.action.StdMatextMergeToUpdate;
import br.com.mind5.business.materialText.model.checker.MatextCheckExist;
import br.com.mind5.business.materialText.model.checker.MatextCheckLangu;
import br.com.mind5.business.materialText.model.checker.MatextCheckLength;
import br.com.mind5.business.materialText.model.checker.MatextCheckMat;
import br.com.mind5.business.materialText.model.checker.MatextCheckOwner;
import br.com.mind5.business.materialText.model.checker.MatextCheckWrite;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootMatextUpdate extends DeciTreeTemplateWriteV2<MatextInfo> {
	
	public RootMatextUpdate(DeciTreeOption<MatextInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatextInfo> buildCheckerHook(DeciTreeOption<MatextInfo> option) {
		List<ModelCheckerV1<MatextInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatextInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatextCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatextCheckLength(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatextCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatextCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatextCheckMat(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatextCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatextInfo>> buildActionsOnPassedHook(DeciTreeOption<MatextInfo> option) {
		List<ActionStdV1<MatextInfo>> actions = new ArrayList<>();

		ActionStdV1<MatextInfo> mergeToUpdate = new StdMatextMergeToUpdate(option);
		ActionLazyV1<MatextInfo> nodeDefault = new LazyMatextNodeDefaultL1(option.conn, option.schemaName);
		ActionLazyV1<MatextInfo> enforceLChanged = new LazyMatextEnforceLChanged(option.conn, option.schemaName);	
		ActionLazyV1<MatextInfo> enforceLChangedBy = new LazyMatextMergeUsername(option.conn, option.schemaName);
		ActionLazyV1<MatextInfo> enforceTxtSearch = new LazyMatextEnforceTxtSearch(option.conn, option.schemaName);
		ActionLazyV1<MatextInfo> update = new LazyMatextDaoUpdate(option.conn, option.schemaName);
		ActionLazyV1<MatextInfo> postUpdate = new LazyMatextNodePostUpdate(option.conn, option.schemaName);
		ActionLazyV1<MatextInfo> select = new LazyMatextRootSelect(option.conn, option.schemaName);	
		
		mergeToUpdate.addPostAction(nodeDefault);
		nodeDefault.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceTxtSearch);
		enforceTxtSearch.addPostAction(update);
		update.addPostAction(postUpdate);
		postUpdate.addPostAction(select);
		
		actions.add(mergeToUpdate);
		return actions;
	}
}
