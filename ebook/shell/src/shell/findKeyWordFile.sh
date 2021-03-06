#!/bin/bash 
#find files contains a keyword 
#write by xiaojing.zhao 
#2012.12.14 
 
echo -e "\nThis is a script to find all the files in a specified path contains a keyword!" 
 
echo -e "\nPlease input a keyword:" 
read key 
if [ "$key" == "" ]; then 
    echo -e "keyword can not be null!\n" 
    exit 0 
fi 
keyword=$key 
 
echo -e "\nPlease input your specified path:" 
read dir 
#»fεHa₯ΫΆέCσ₯ΪU_CsΆέoρ¦ 
test ! -d $dir && echo -e "The $dir is not exist in your system.\n\n" && exit 0 
 
echo -e "\n---------------You find files are:---------------\n" 
 
#keyword=JAVA_OPTS 
#dir=/jboss/jboss-eap-4.3/jboss-as/ 
 
#ί~‘Ά’ 
file_count=0 
#R_εgΕLΪU_C¦Ε[HaCs>f¦σs 
file_list=`ls -R $dir 2> /dev/null | grep -v '^$'` 
for file_name in $file_list 
do 
    #4NφeΆΨSΚtempC«ls -R¦file_listIΆΌLCz:@Ϊκ’½½’CΣi.γ\CΣC*γ\0’½½’$γ\sφΣ~©jSΗΦbc:NΩ 
    #{USIτCA₯cfile_nameΨSΚICzFIsC«F@ΰeΦbc:Nσ 
    temp=`echo $file_name | sed 's/:.*$//g'` 
    #@Κ4NφeΆΨSΚtemp₯κ’ΪU_C§ρΆCA«εΪU_K<PΩ~cur_dirΨSΚ 
    if [ "$file_name" != "$temp" ]; then 
        cur_dir=$temp 
        #echo "-"$cur_dir #4Nφe>f¦CΥp 
    else 
        #pfile½ίεgΕΆ^g₯Ϋ:NASCII text{|^ 
        file_type=`file $cur_dir/$file_name | grep "text"` 
        if [ "$file_type" != "" ]; then 
            temp=`grep $keyword $cur_dir/$file_name 2> /dev/null` 
            #echo "--"$cur_dir/$file_name #4Nφe>f¦CΥp 
            if [ "$temp" != "" ]; then 
                echo $cur_dir/$file_name 
                #Ά’Α1 
                let file_count++ 
            fi 
        fi 
    fi 
done 
 
echo -e "\n-------------------------------------------------" 
echo -e "\n\nFiles Total: $file_count" 
echo -e "\nFind Finished!\n" 