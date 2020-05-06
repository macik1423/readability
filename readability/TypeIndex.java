package readability;

public enum TypeIndex {
    ARI {
        @Override
        public Index getTypeIndex() {
            return new IndexARI();
        }
    },
    FK {
        @Override
        public Index getTypeIndex() {
            return new IndexFK();
        }
    },
    SMOG {
        @Override
        public Index getTypeIndex() {
            return new IndexSMOG();
        }
    },
    CL {
        @Override
        public Index getTypeIndex() {
            return new IndexCL();
        }
    };

    public abstract Index getTypeIndex();
}
