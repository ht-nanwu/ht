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
#”»’få‹˜HŒa¥”Û‘¶İC›óŠ¥–ÚU_C•s‘¶İ“o’ñ¦ 
test ! -d $dir && echo -e "The $dir is not exist in your system.\n\n" && exit 0 
 
echo -e "\n---------------You find files are:---------------\n" 
 
#keyword=JAVA_OPTS 
#dir=/jboss/jboss-eap-4.3/jboss-as/ 
 
#ß~¡‹•¶Œ˜¢” 
file_count=0 
#R_ågŠÅŠ—L–ÚU_C‘¦Å[˜HŒaC•s>f¦‹ós 
file_list=`ls -R $dir 2> /dev/null | grep -v '^$'` 
for file_name in $file_list 
do 
    #4Nöe•¶ŒØS—ÊtempC«ls -R‘¦file_list’†“I•¶Œ–¼’†Š—L•C”z:@Úˆê˜¢ˆ½‘½˜¢”CˆÓš•„i.‘ã•\”CˆÓš•„C*‘ã•\0˜¢ˆ½‘½˜¢$‘ã•\s”öÓ~‘©•„j‘S‹Ç‘Öbc:NÙ 
    #€{US“Iô‹CA¥”cfile_nameØS—Ê’†“I•C”zF“IsC«F@“à—e‘Öbc:N‹ó 
    temp=`echo $file_name | sed 's/:.*$//g'` 
    #”@‰Ê4Nöe•¶ŒØS—Êtemp¥ˆê˜¢–ÚU_C§”ñ•¶ŒCA«å‹–ÚU_K<PÙ~cur_dirØS—Ê 
    if [ "$file_name" != "$temp" ]; then 
        cur_dir=$temp 
        #echo "-"$cur_dir #4Nöe>f¦CŒÕ‹—p 
    else 
        #—pfile–½—ßågŠÅ•¶Œ^g¥”Û:NASCII text{|Œ^ 
        file_type=`file $cur_dir/$file_name | grep "text"` 
        if [ "$file_type" != "" ]; then 
            temp=`grep $keyword $cur_dir/$file_name 2> /dev/null` 
            #echo "--"$cur_dir/$file_name #4Nöe>f¦CŒÕ‹—p 
            if [ "$temp" != "" ]; then 
                echo $cur_dir/$file_name 
                #•¶Œ˜¢”‰Á1 
                let file_count++ 
            fi 
        fi 
    fi 
done 
 
echo -e "\n-------------------------------------------------" 
echo -e "\n\nFiles Total: $file_count" 
echo -e "\nFind Finished!\n" 