package tfsc.test;

import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.ldap.filter.LikeFilter;
import org.springframework.ldap.filter.OrFilter;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import java.util.List;

/**
 * Created by sharanya.p on 7/9/2018.
 */
public class LDAPTest {

    public static void main(String[] args) {
        /*try {*/
            //String userName = "*******";
            //String password = "********";
            //String base = "DC=PSLTESTDOMAIN,DC=LOCAL";
            //String dn = "cn=" + userName + "," + base;
            /*LdapContextSource contextSource = new LdapContextSource();
            contextSource.setUrl("LDAP://172.30.0.110:389/DC=247-inc,DC=com");
            contextSource.setUserDn("pxoe-mailer");
            contextSource.setPassword("spirit123456$");
            contextSource.afterPropertiesSet();

            String[] searchStrMultiple = {"sha"};

            OrFilter andFilter = new OrFilter();
            for (String s : searchStrMultiple) {
                s = s.trim();
                if (s == null || s.length() == 0) {
                    continue;
                }
                andFilter.or(new LikeFilter("sAMAccountName", s + "*"));
            }
            LdapTemplate ldapTemplate = new LdapTemplate(contextSource);
            ldapTemplate.setIgnorePartialResultException(true);

            List t = ldapTemplate.search("", andFilter.encode(),
                    new AttributesMapper() {
                        public Object mapFromAttributes(Attributes attrs)
                                throws NamingException {
                            NamingEnumeration<? extends Attribute> t = attrs.getAll();
                            return attrs.get("sAMAccountName").get();
                        }
                    });
            System.out.println(t);

        }catch (Exception e){
            e.printStackTrace();
        }*/
    }


}
