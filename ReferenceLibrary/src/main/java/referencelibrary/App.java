package referencelibrary;

import referencelibrary.reference.Reference;
import referencelibrary.data.ReferenceDao;
import referencelibrary.util.BibTeXConverter;
import referencelibrary.util.DuplicateNameException;
import referencelibrary.util.FileUtil;

import java.util.List;

/**
 * Created by petri on 11/04/16.
 */
public class App {

    private ReferenceDao references;

    public App(ReferenceDao references) {
        this.references = references;
    }

    public void newReference(Reference reference) throws DuplicateNameException {
        references.add(reference);
    }

    public List<Reference> listReferences() {
        return references.listAll();
    }
        
    public void generateBixTexFile(String filename) {
        //convert all references to BibTeX-format
        StringBuilder bibtexStringBuilder = new StringBuilder();
        for (Reference r : this.references.listAll()) {
            String refString = BibTeXConverter.convertToBibTeX(r);
            bibtexStringBuilder.append(refString);
        }
        //save String containing bibtex-references to File
        FileUtil.Write(filename, bibtexStringBuilder.toString());
    }
}
