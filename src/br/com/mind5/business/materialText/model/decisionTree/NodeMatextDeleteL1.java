package br.com.mind5.business.materialText.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.model.action.LazyMatextDaoDelete;
import br.com.mind5.business.materialText.model.action.LazyMatextMergeUsername;
import br.com.mind5.business.materialText.model.action.LazyMatextDaoUpdate;
import br.com.mind5.business.materialText.model.action.StdMatextEnforceLChanged;
import br.com.mind5.business.materialText.model.checker.MatextCheckDummy;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV1;

public final class NodeMatextDeleteL1 extends DeciTreeTemplateWriteV1<MatextInfo> {

	public NodeMatextDeleteL1(DeciTreeOption<MatextInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<MatextInfo> buildCheckerHook(DeciTreeOption<MatextInfo> option) {
		List<ModelCheckerV1<MatextInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<MatextInfo> checker;
			
		checker = new MatextCheckDummy();
		queue.add(checker);

		return new ModelCheckerHelperQueueV2<MatextInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatextInfo>> buildActionsOnPassedHook(DeciTreeOption<MatextInfo> option) {
		List<ActionStdV1<MatextInfo>> actions = new ArrayList<>();
		
		ActionStdV1<MatextInfo> enforceLChanged = new StdMatextEnforceLChanged(option);
		ActionLazyV1<MatextInfo> enforceLChangedBy = new LazyMatextMergeUsername(option.conn, option.schemaName);
		ActionLazyV1<MatextInfo> update = new LazyMatextDaoUpdate(option.conn, option.schemaName);
		ActionLazyV1<MatextInfo> delete = new LazyMatextDaoDelete(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		update.addPostAction(delete);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
