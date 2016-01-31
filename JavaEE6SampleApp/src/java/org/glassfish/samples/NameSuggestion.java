/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glassfish.samples;

import java.util.List;
import javax.enterprise.inject.Model;
import org.glassfish.samples.entities.Customer;

/**
 *
 * @author arun
 */
@Model
public class NameSuggestion {
    private String hint;
    private List<Customer> suggestions;

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public List<Customer> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(List<Customer> suggestions) {
        this.suggestions = suggestions;
    }
}
