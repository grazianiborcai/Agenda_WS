package br.com.mind5.model.decisionTree.obsolete;

import br.com.mind5.info.InfoRecord;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public interface DeciTreeFactory_<T extends InfoRecord> {
	public DeciTree<T> getInstance(DeciTreeOption<T> option);
}
